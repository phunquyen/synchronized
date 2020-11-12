package com.xtel.training.synchronize;

public class TestThread {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread 1_1", 1);
        MyThread t2 = new MyThread("Thread 1_2", 10);
        MyThread t3 = new MyThread("Thread 1_3", 100);
        t1.start();
        t2.start();
        t3.start();
    }

    static class Table {
        synchronized static void print(String name, int n) {
            for (int i = 1; i <= 5; i++)
                System.out.println(name + ": " + i * n);
        }
    }

    static class MyThread extends Thread {
        private String name;
        private int value;

        public MyThread(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public void run() {
            Table.print(name, value);
        }
    }
}
