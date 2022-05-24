package cn.jjx.coding.leetcode.classification.dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC296_最佳的碰头地点_hard {

    //只要相遇点左边和右边有相同数目的点，总距离都是最小的。
    //所以本题只需要拆成一维的，分别求row和col即可。
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        int row = rows.get(rows.size() / 2);
        Collections.sort(cols);
        int col = cols.get(cols.size() / 2);
        return minDistance1D(rows, row) + minDistance1D(cols, col);
    }

    private int minDistance1D(List<Integer> points, int origin) {
        int distance = 0;
        for (int point : points) {
            distance += Math.abs(point - origin);
        }
        return distance;
    }

}
