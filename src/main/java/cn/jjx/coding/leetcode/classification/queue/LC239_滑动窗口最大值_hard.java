package cn.jjx.coding.leetcode.classification.queue;

import java.util.Deque;
import java.util.LinkedList;

public class LC239_滑动窗口最大值_hard {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //单调队列存的是下标
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[n-k+1];
        ans[0] = nums[deque.peekFirst()];
        for(int i=k;i<n;i++){
            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while(deque.peekFirst() <= i-k){
                deque.pollFirst();
            }
            ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;

    }
}
