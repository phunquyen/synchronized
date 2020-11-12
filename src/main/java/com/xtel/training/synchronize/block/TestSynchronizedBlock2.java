package com.xtel.training.synchronize.block;

public class TestSynchronizedBlock2 {
    public static void main(String[] args) {
        final TableBlock2 obj = new TableBlock2();
        Thread t1 = new Thread() {
            public void run() {
                obj.printTable(5);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                obj.printTable(100);
            }
        };
        t1.start();
        t2.start();
    }
}

class TableBlock2 {
    void printTable(int n) {
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
