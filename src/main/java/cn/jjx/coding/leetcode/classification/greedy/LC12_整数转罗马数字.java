package cn.jjx.coding.leetcode.classification.greedy;

public class LC12_整数转罗马数字 {
    public String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中，
        // 并且按照阿拉伯数字的大小降序排列
        int[] nums = {1000, 900, 500, 400, 100, 90, 50,
                40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L",
                "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();
        int index=0;
        while(index<13){
            while(num>=nums[index]){
                stringBuilder.append(romans[index]);
                num-=nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }
}
