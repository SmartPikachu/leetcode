package cn.jjx.coding.leetcode.classification.backtracing.排列;

import java.util.ArrayList;
import java.util.LinkedList;
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

public class LC46_全排列_mid {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0) return result;
        used=new boolean[nums.length];
        permuteHelper(nums);
        return result;
    }

    public void permuteHelper(int[] nums){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){continue;}
            used[i]=true;
            //选择当前元素
            path.add(nums[i]);
            permuteHelper(nums);
            //不选当前元素
            path.removeLast();
            used[i]=false;
        }
    }

}
