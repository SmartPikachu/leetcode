package cn.jjx.coding.leetcode.classification.queue;

import java.util.PriorityQueue;

public class LC295_数据流的中位数 {

    class MedianFinder {
        PriorityQueue<Integer> queMin;
        PriorityQueue<Integer> queMax;

        public MedianFinder() {
            queMin = new PriorityQueue<>((a,b)->(b-a));
            queMax = new PriorityQueue<>((a,b)->(a-b));
        }

        public void addNum(int num) {
            if(queMin.isEmpty() || num<=queMin.peek()){
                queMin.offer(num);
                if(queMax.size()+1<queMin.size()){
                    queMax.offer(queMin.poll());
                }
            }else{
                queMax.offer(num);
                if(queMax.size()>queMin.size()){
                    queMin.offer(queMax.poll());
                }
            }

        }

        public double findMedian() {
            if(queMin.size()>queMax.size()){
                return queMin.peek();
            }
            return (queMin.peek()+queMax.peek())/2.0;
        }
    }

}
