package cn.jjx.coding.leetcode.多线程;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LC1115_交替打印FooBar_mid {

    //采用Semaphore方法
    class FooBar {
        private int n;

        private Semaphore fooSema = new Semaphore(1);
        private Semaphore barSema = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                fooSema.acquire();//值为1的时候，能拿到，执行下面的操作
                printFoo.run();
                barSema.release();//释放许可给barSema这个信号量 barSema 的值+1
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                barSema.acquire();//值为1的时候，能拿到，执行下面的操作
                printBar.run();
                fooSema.release();//释放许可给fooSema这个信号量 fooSema 的值+1
            }
        }
    }


    //采用CyclicBarrier方法
    class FooBar1 {
        private int n;

        private CyclicBarrier cb = new CyclicBarrier(2);
        volatile boolean fooExec = true;

        public FooBar1(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (!fooExec) {
                    //false的时候，bar线程在执行，foo线程在这此处空转
                }
                printFoo.run();//打印foo
                fooExec = false;//设置变量
                try {
                    cb.await();//线程foo到达同步点
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                printBar.run();
                fooExec = true;

            }
        }
    }


    //采用ReentrantLock的方法
    class FooBar2 {
        private int n;
        private ReentrantLock lock = new ReentrantLock(true);
        volatile boolean fooExec = true;

        public FooBar2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; ) {
                lock.lock();
                try {
                    if (fooExec) {
                        printFoo.run();
                        fooExec = false;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; ) {
                lock.lock();
                try {
                    if (!fooExec) {
                        printBar.run();
                        fooExec = true;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }



    //采用BlockingQueue的方法
    class FooBar3 {
        private int n;
        private BlockingQueue<Integer> fooQueue = new LinkedBlockingQueue<Integer>() {{
            add(0);
        }};
        private BlockingQueue<Integer> barQueue = new LinkedBlockingQueue<>();

        public FooBar3(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                fooQueue.take();
                printFoo.run();
                barQueue.add(0);
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                barQueue.take();
                printBar.run();
                fooQueue.add(0);
            }
        }
    }


    //采用Thread.yield的方法
    class FooBar4 {
        private int n;

        volatile boolean fooExec = true;//foo可以执行

        public FooBar4(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; ) {
                if (fooExec) {
                    printFoo.run();
                    fooExec = false;
                    i++;
                } else {
                    Thread.yield();
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; ) {
                if (!fooExec) {
                    printBar.run();
                    fooExec = true;
                    i++;
                } else {
                    Thread.yield();
                }

            }
        }
    }


    //采用synchronized的方法
    class FooBar6 {
        private int n;
        private Object obj = new Object();
        private volatile boolean fooExec = true;

        public FooBar6(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (obj) {
                    if (!fooExec) {//fooExec为false时，该线程等待，为true的时候执行下面的操作
                        obj.wait();
                    }
                    printFoo.run();
                    fooExec = false;
                    obj.notifyAll();//唤醒其他线程
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (obj) {
                    if (fooExec) {
                        obj.wait();
                    }
                    printBar.run();
                    fooExec = true;
                    obj.notifyAll();
                }

            }
        }
    }


    //采用LockSupport的方法
    class FooBar7 {
        private int n;
        private Map<String, Thread> map = new ConcurrentHashMap<>();
        private volatile boolean fooExec = true;

        public FooBar7(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            map.put("foo", Thread.currentThread());
            for (int i = 0; i < n; i++) {
                while (!fooExec) {
                    LockSupport.park();
                }
                printFoo.run();
                fooExec = false;
                LockSupport.unpark(map.get("bar"));
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            map.put("bar", Thread.currentThread());
            for (int i = 0; i < n; i++) {
                while (fooExec) {
                    LockSupport.park();
                }
                printBar.run();
                fooExec = true;
                LockSupport.unpark(map.get("foo"));
            }
        }
    }



}
