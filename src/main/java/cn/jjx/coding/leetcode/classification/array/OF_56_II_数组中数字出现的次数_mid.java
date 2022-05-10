package cn.jjx.coding.leetcode.classification.array;

public class OF_56_II_数组中数字出现的次数_mid {

    //利用状态机的方法，时间复杂度和空间复杂度都是O（1）
    //但是比较难于理解
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    //利用位运算的方法，比较容易理解
    public int singleNumber1(int[] nums) {
        int[] counts = new int[32];
        for(int num:nums){
            for(int j=0;j<32;j++){
                counts[j]+=num&1;
                num>>>=1;
            }
        }
        int res=0,m=3;
        for(int i=0;i<32;i++){
            res<<=1;
            res|=counts[31-i]%m;
        }
        return res;

    }

}
