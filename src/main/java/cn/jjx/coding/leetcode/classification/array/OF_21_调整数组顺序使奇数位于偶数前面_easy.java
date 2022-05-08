package cn.jjx.coding.leetcode.classification.array;

public class OF_21_调整数组顺序使奇数位于偶数前面_easy {

    public int[] exchange(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<j){
            while(i<j&&(nums[i]&1)==1) i++;
            while(i<j&&(nums[j]&1)==0) j--;
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        return nums;
    }
}
