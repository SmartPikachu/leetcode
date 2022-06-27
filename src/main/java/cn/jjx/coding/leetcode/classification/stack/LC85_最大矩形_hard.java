package cn.jjx.coding.leetcode.classification.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LC85_最大矩形_hard {

    //这道题自己画图，然后才能看出这个单调栈，不然这个解法不容易看懂
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        //这块其实是以i,j为尾，左边最大的面积
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int j = 0; j < n; j++) { // 对于每一列，使用基于柱状图的方法
            int[] up = new int[m];
            int[] down = new int[m];

            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                //如果栈的最大元素大于left[i][j]则把它弹出，因为求面积是靠这一列中最短的left[i][j],
                //所以这个栈其实是个单调递增的，随着i的增大递增的，stack.peek()相比于i是前一个元素，这个i是从小到大的方向
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                //这个i是从大到小的方向，也是随着i的减小，栈是单调递增的，这样计算才有意义。
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }
}
