package cn.jjx.coding.leetcode.多线程;

import java.util.concurrent.atomic.AtomicInteger;

public class LC1114_按序打印_easy {

    class Foo {

        private final AtomicInteger firstJobDone = new AtomicInteger(0);
        private final AtomicInteger secondJobDone = new AtomicInteger(0);

        public Foo() {}

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first".
            printFirst.run();
            // mark the first job as done, by increasing its count.
            firstJobDone.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (firstJobDone.get() != 1) {
                // waiting for the first job to be done.
            }
            // printSecond.run() outputs "second".
            printSecond.run();
            // mark the second as done, by increasing its count.
            secondJobDone.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (secondJobDone.get() != 1) {
                // waiting for the second job to be done.
            }
            // printThird.run() outputs "third".
            printThird.run();
        }
    }


}
