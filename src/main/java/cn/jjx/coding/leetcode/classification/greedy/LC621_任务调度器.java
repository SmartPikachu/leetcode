package cn.jjx.coding.leetcode.classification.greedy;

import java.util.*;

public class LC621_任务调度器 {

    public int leastInterval(char[] tasks, int n) {
        //利用桶思想，如果间隔时间足够长的情况是下面这样，
        // 总排队时间 = (桶个数 - 1) * (n + 1) + 最后一桶的任务数，
        //如果间隔时间比较短
        int[] bukets = new int[26];
        for(int i=0;i<tasks.length;i++){
            bukets[tasks[i]-'A']++;
        }
        Arrays.sort(bukets);
        int maxTimes = bukets[25];
        int maxCount=1;
        for(int i=25;i>=1;i--){
            if(bukets[i]==bukets[i-1]){
                maxCount++;
            }else{
                break;
            }
        }
        int res = (maxTimes-1)*(n+1)+maxCount;
        return Math.max(res,tasks.length);
    }

}
