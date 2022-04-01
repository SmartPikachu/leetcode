package cn.jjx.coding.leetcode.classification.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90_子集II {

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        dfs(false, cur + 1, nums);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        t.add(nums[cur]);
        dfs(true, cur + 1, nums);
        t.remove(t.size() - 1);
    }


    //下面是自己写的
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null || nums.length==0) return ans;
        List<Integer> temp = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(ans,temp,nums,0,visited);
        return ans;
    }

    public void backtrace(List<List<Integer>> ans,List<Integer> temp,int[] nums,int idx,boolean[] visited){
        if(idx==nums.length){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        backtrace(ans,temp,nums,idx+1,visited);

        if(idx>0 && nums[idx-1]==nums[idx] && !visited[idx-1]){
            return;
        }

        visited[idx]=true;
        temp.add(nums[idx]);
        backtrace(ans,temp,nums,idx+1,visited);
        temp.remove(temp.size()-1);
        visited[idx]=false;
    }

}
