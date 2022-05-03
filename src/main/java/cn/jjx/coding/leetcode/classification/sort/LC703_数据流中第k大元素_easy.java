package cn.jjx.coding.leetcode.classification.sort;

import java.util.PriorityQueue;

public class LC703_数据流中第k大元素_easy {
    PriorityQueue<Integer> pq;
    int k;

    public LC703_数据流中第k大元素_easy(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

}
