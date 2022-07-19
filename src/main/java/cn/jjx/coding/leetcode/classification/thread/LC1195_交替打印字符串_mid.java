package cn.jjx.coding.leetcode.classification.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

public class LC1195_交替打印字符串_mid {

    //利用CyclicBarrier
    static class FizzBuzz {
        private int n;
        private static CyclicBarrier barrier = new CyclicBarrier(4);

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                }
                try {
                    barrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 == 0) {
                    printBuzz.run();
                }
                try {
                    barrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz.run();
                }
                try {
                    barrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                }
                try {
                    barrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    //利用Thread.yield()方法
    class FizzBuzz1 {
        private int n;
        private volatile int m = 1;
        private volatile int flag = 0;

        public FizzBuzz1(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while(m <= n){
                while(flag !=1 && m <= n){
                    Thread.yield();
                }
                if(m > n){
                    return;
                }
                if(m % 3 == 0){
                    printFizz.run();
                    m++;
                    flag = 0;
                }else{
                    flag = 2;
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while(m <= n){
                while(flag != 2 && m <= n){
                    Thread.yield();
                }
                if(m > n){
                    return;
                }
                if(m % 5 == 0){
                    printBuzz.run();
                    m++;
                    flag = 0;
                }else{
                    flag = 3;
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while(m <= n){
                while(flag != 0 && m <= n){
                    Thread.yield();
                }
                if(m > n){
                    return;
                }
                if(m % 3 == 0 && m % 5 == 0){
                    printFizzBuzz.run();
                    m++;
                    flag = 0;
                }else{
                    flag = 1;
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while(m <= n){
                while(flag != 3 && m <= n){
                    Thread.yield();
                }
                if(m > n){
                    return;
                }
                printNumber.accept(m);
                m++;
                flag = 0;
            }
        }
    }
}
