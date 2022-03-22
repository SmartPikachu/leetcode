package cn.jjx.coding.leetcode.labuladong.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LC452_用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
/**        这么写会有int溢出的可能
 *         Arrays.sort(points, new Comparator<int[]>() {
 *             public int compare(int[] point1, int[] point2) {
 *                 return point1[1]-point2[1];
 *             }
 *         });
 */

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
