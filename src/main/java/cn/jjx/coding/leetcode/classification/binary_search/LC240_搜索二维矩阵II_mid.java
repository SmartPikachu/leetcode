package cn.jjx.coding.leetcode.classification.binary_search;

public class LC240_搜索二维矩阵II_mid {

    //方法一是通过Z字型查找，这个是官方的题解的方法三。
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

    //宫水三叶的二分法，不过明显不如上面的解法优秀。
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (matrix[i][mid] <= target) l = mid;
                else r = mid - 1;
            }
            if (matrix[i][r] == target) return true;
        }
        return false;
    }

}
