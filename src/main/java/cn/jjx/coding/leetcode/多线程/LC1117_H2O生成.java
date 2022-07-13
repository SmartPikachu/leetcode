package cn.jjx.coding.leetcode.多线程;

import java.util.concurrent.Semaphore;

public class LC1117_H2O生成 {

    class H2O {
        private Semaphore h = new Semaphore(2);
        private Semaphore o = new Semaphore(0);

        public H2O() {
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            o.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire(2);
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            h.release(2);
        }
    }

}
