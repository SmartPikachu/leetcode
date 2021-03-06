package cn.jjx.coding.leetcode.classification.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LC503_下一个更大元素II_mid {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret,-1);
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0;i<2*n-1;i++){
            while(!stack.isEmpty()&&nums[stack.peek()]<nums[i%n]){
                ret[stack.pop()]=nums[i%n];
            }
            stack.push(i%n);
        }
        return ret;
    }
}
