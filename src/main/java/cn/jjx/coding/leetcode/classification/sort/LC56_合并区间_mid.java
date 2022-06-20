package cn.jjx.coding.leetcode.classification.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class LC56_合并区间_mid {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        /**
         * 这么写lanbada表达式更优雅
         * Arrays.sort(intervals, Comparator.comparingInt((interval->interval[0])));
         *
         * //这个完全是匿名内部类
         * Arrays.sort(intervals, new Comparator<int[]>() {
         *             public int compare(int[] interval1, int[] interval2) {
         *                 return interval1[0] - interval2[0];
         *             }
         *         });
         */

        List<int[]> merged = new ArrayList<>();
        for(int i = 0; i < intervals.length; ++i){
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] =
                        Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }

        /**
         * 这种是利用流
         * IntStream.range(0, intervals.length).forEach(i -> {
         *             int L = intervals[i][0], R = intervals[i][1];
         *             if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
         *                 merged.add(new int[]{L, R});
         *             } else {
         *                 merged.get(merged.size() - 1)[1] =
         *                         Math.max(merged.get(merged.size() - 1)[1], R);
         *             }
         *         });
         */
        return merged.toArray(new int[merged.size()][]);
    }
}
