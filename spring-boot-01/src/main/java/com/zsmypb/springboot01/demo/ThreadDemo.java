package com.zsmypb.springboot01.demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangs.
 * sleep wait
 * 区别：1、sleep()没有释放锁，只有等暂停的时间结束了才会释放锁； wait()方法释放了锁，别的线程可以使用对象
 * 2、使用wait()方法要使用synchronized关键字，否则会抛出IllegalMonitorStateException异常
 *
 */
public class ThreadDemo {

    ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(new Thread1()).start();

        new Thread(new Thread2()).start();

//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private static class Thread1 implements Runnable{
        @Override
        public void run(){
            synchronized (ThreadDemo.class) {
                System.out.println("enter thread1 is waiting..");
                try {
                    //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                    //静态同步块或静态同步方法使用的锁是该方法所在类的字节码文件对象，类名.class
                    ThreadDemo.class.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on ....");
                System.out.println("thread1 is over!!!");
            }
        }
    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {
            synchronized (ThreadDemo.class) {
                System.out.println("enter thread2 is sleep....");
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
                ThreadDemo.class.notify();

                //区别
                //如果我们把代码：MyTestDemo.class.notify();给注释掉，MyTestDemo.class调用了wait()方法，但是没有调用notify()方法，则线程永远处于挂起状态。
                try {
                    //sleep()方法导致了程序暂停执行指定的时间，让出cpu给其他线程，
                    //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                    //在调用sleep()方法的过程中，线程不会释放对象锁。
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on....");
                System.out.println("thread2 is over!!!");
            }
        }
    }
}


