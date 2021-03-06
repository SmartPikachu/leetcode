package cn.jjx.coding.leetcode.classification.array.几数之和;

import java.util.HashMap;

//前缀和+哈希表的解法
public class LC560_和为K的子数组_mid {
    public int subarraySum(int[] nums, int k) {
        int count=0,pre=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            if(mp.containsKey(pre-k)){
                count+=mp.get(pre-k);
            }
            mp.put(pre,mp.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
