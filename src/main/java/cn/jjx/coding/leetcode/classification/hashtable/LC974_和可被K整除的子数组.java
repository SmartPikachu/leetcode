package cn.jjx.coding.leetcode.classification.hashtable;

import java.util.HashMap;
import java.util.Map;

public class LC974_和可被K整除的子数组 {

    //哈希表 + 逐一统计
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> record = new HashMap<>();
        //这个是为单个数准备的
        record.put(0,1);
        int sum=0,ans=0;
        for(int elem:nums){
            sum+=elem;
            //注意java取模的特殊性，被除数为负数时取模结果也为负数，需要纠正
            int modulus = (sum%k+k)%k;
            int same = record.getOrDefault(modulus,0);
            ans+=same;
            record.put(modulus,same+1);
        }
        return ans;

    }

    //哈希表 + 单次统计,这种排列组合的做法不是很好想得出来,其实不太推荐。
    public int subarraysDivByK1(int[] nums, int k) {
         Map<Integer,Integer> record = new HashMap<>();
         record.put(0,1);
         int sum=0;
         for(int elem:nums){
             sum+=elem;
             int modulus = (sum%k+k)%k;
             record.put(modulus,record.getOrDefault(modulus,0)+1);
         }
         int ans=0;
         for(Map.Entry<Integer,Integer> entry:record.entrySet()){
             ans+=entry.getValue()*(entry.getValue()-1)/2;
         }
         return ans;
    }
}
