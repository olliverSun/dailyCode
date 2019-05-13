package 死锁;

import 线程交互.Hreo;

public class DieLock {




    public  static void main(String[] args){
       final Hreo a = new Hreo();
       final Hreo b = new Hreo();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                    synchronized (a){
                        System.out.println("a"+Thread.currentThread().getName());
                        try {
                            Thread.sleep(50000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (b){
                            System.out.println("b"+Thread.currentThread().getName());
                        }
                    }
            }
        });
        t1.start();


        Thread t2 =new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b){
                    System.out.println("b"+Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (a){
                        System.out.println("b"+Thread.currentThread().getName());
                    }
                }
            }
        });
        t2.start();

    }


}
