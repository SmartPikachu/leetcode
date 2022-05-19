package cn.jjx.coding.leetcode.classification.array;

public class LC498_对角线遍历_mid {

    //本题并没有选择官方题解
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[m * n];

        int k = 0;
        boolean bXFlag = true;
        for (int i = 0; i < m+n-1; i++){
            int pm = bXFlag ? m : n;
            int pn = bXFlag ? n : m;

            int x = (i < pm) ? i : pm - 1;
            int y = i - x;

            while (x >= 0 && y < pn){
                nums[k++] = bXFlag ? matrix[x][y] : matrix[y][x];
                x--;
                y++;
            }

            bXFlag = !bXFlag;
        }

        return nums;
    }
}
