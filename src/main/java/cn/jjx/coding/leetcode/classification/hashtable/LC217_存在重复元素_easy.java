package cn.jjx.coding.leetcode.classification.hashtable;

import java.util.HashSet;
import java.util.Set;

public class LC217_存在重复元素_easy {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x:nums){
            if(!set.add(x)){
                return true;
            }
        }
        return false;
    }
}
