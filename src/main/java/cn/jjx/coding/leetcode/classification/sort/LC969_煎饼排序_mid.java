package cn.jjx.coding.leetcode.classification.sort;

import java.util.ArrayList;
import java.util.List;

public class LC969_煎饼排序_mid {

    public List<Integer> pancakeSort(int[] arr) {
        /**
         * 第一步选择 k=index+1，然后反转子数组arr[0...k−1]，此时该元素已经被放到首部。
         *第二步选择 k=n，其中n是数组arr的长度，然后反转整个数组，此时该元素已经被放到尾部。
         */
        List<Integer> ret = new ArrayList<Integer>();
        for(int n=arr.length;n>1;n--){
            int index=0;
            for(int i=1;i<n;i++){
                if(arr[i]>=arr[index]){
                    index=i;
                }
            }
            if(index==n-1){
                continue;
            }
            reverse(arr,index);
            reverse(arr,n-1);
            ret.add(index+1);
            ret.add(n);
        }
        return ret;
    }

    public void reverse(int[] arr,int end){
        for(int i=0,j=end;i<j;i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }

}
