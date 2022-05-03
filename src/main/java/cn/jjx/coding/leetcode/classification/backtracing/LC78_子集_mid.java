package cn.jjx.coding.leetcode.classification.backtracing;

import java.util.ArrayList;
import java.util.List;

public class LC78_子集_mid {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return ans;
    }
    public void dfs(int cur,int[] nums){
        if(cur==nums.length){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        //递归取cur位置的元素
        list.add(nums[cur]);
        dfs(cur+1,nums);
        list.remove(list.size()-1);
        //递归，如果不取cur位置的元素
        dfs(cur+1,nums);
    }
}
