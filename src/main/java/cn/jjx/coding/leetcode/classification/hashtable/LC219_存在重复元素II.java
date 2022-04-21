package cn.jjx.coding.leetcode.classification.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC219_存在重复元素II {

    //使用哈希表
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i=0;i<length;i++){
            int num = nums[i];
            if(map.containsKey(num) && i-map.get(num)<=k){
                return true;
            }
            map.put(num,i);
        }
        return false;
    }

    //使用滑动窗口的方法
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for(int i=0;i<length;i++){
            if(i>k){
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
