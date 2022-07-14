package cn.jjx.coding.leetcode.classification.array;

public class LC48_旋转图像_mid {

    //原地旋转，直接推导出一个格子点，旋转360度的不同位置，找出这四个表达式即可。
    //注意坐标系的坐标
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

}
