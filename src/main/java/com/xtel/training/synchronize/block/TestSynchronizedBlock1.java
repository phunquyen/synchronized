package com.xtel.training.synchronize.block;

public class TestSynchronizedBlock1 {
    public static void main(String[] args) {
        TableBlock obj = new TableBlock();
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        t1.start();
        t2.start();
    }
}
class TableBlock {
    void printTable (int n) {
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

class MyThread1 extends Thread {
    TableBlock t;
    MyThread1(TableBlock t) {
        this.t = t;
    }
    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread {
    TableBlock t;
    MyThread2(TableBlock t) {
        this.t = t;
    }
    public void run() {
        t.printTable(100);
    }
}