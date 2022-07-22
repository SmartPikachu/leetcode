package cn.jjx.coding.leetcode.classification.dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC296_最佳的碰头地点_hard {

    //这道hard的题是个非典型的题，感觉很一般。

    /**
     * 官方题解方法三
     *排序的方法,只要相遇点左边和右边有相同数目的点，总距离都是最小的。
     * 所以本题只需要拆成一维的，分别求row和col即可。
     */
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

    /**
     * 官方题解四----按顺序收集坐标
     * 我们可以使用 快速选择算法 在O(mn)的时间内得到中位数，但还有更简单的方法。
     * 我们可以按顺序收集行和列的坐标，就不需要排序了。
     */
    class Solution{
        public int minTotalDistance(int[][] grid) {
            List<Integer> rows = collectRows(grid);
            List<Integer> cols = collectCols(grid);
            int row = rows.get(rows.size() / 2);
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

        private List<Integer> collectRows(int[][] grid) {
            List<Integer> rows = new ArrayList<>();
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == 1) {
                        rows.add(row);
                    }
                }
            }
            return rows;
        }

        private List<Integer> collectCols(int[][] grid) {
            List<Integer> cols = new ArrayList<>();
            for (int col = 0; col < grid[0].length; col++) {
                for (int row = 0; row < grid.length; row++) {
                    if (grid[row][col] == 1) {
                        cols.add(col);
                    }
                }
            }
            return cols;
        }
    }

}
