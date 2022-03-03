package cn.jjx.coding.leetcode.labuladong.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 */

public class LC46_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len==0){
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        backtracking(res,used,nums,path,len,0);
        return res;
    }

    private void backtracking(List<List<Integer>> res,boolean[] used,int[] nums,List<Integer> path,int len, int depth){
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<len;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i]=true;
                backtracking(res,used,nums,path,len,depth+1);
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}
