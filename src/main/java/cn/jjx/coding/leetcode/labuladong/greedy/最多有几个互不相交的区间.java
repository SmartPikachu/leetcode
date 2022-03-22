package cn.jjx.coding.leetcode.labuladong.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class 最多有几个互不相交的区间 {
    int intervalSchedule(int[][] intvs){
        if(intvs.length==0) return 0;
        //按照end升序排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        //至少有一个区间不相交
        int count=1;
        //排序后第一区间就是x
        int end = intvs[0][1];
        for(int[] interval:intvs){
            int start=interval[0];
            if(start>=end){
                count++;
                end=interval[1];
            }
        }
        return count;
    }
}
