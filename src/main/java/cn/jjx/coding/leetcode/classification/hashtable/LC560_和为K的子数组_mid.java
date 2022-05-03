package cn.jjx.coding.leetcode.classification.hashtable;

import java.util.HashMap;

public class LC560_和为K的子数组_mid {
    //前缀后+哈希表优化
    public int subarraySum(int[] nums, int k) {
        int count=0,pre=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;

    }
}
