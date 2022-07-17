package cn.jjx.coding.leetcode.classification.backtracing.排列;

import java.util.Arrays;

public class LC60_排列序列_hard {

    //官方题解，直接计算每一个位是哪个数字，最后拼接，
    // 方法非常简洁，不过需要找出规律，这个你只需要拿n=3举例
    //k=3,那么这个数是213,然后你模拟一下。
    class Solution1 {
        public String getPermutation(int n, int k) {
            int[] factorial = new int[n];
            factorial[0] = 1;
            for (int i = 1; i < n; ++i) {
                factorial[i] = factorial[i - 1] * i;
            }

            --k;
            StringBuilder ans = new StringBuilder();
            int[] valid = new int[n + 1];
            Arrays.fill(valid, 1);
            for (int i = 1; i <= n; ++i) {
                int order = k / factorial[n - i] + 1;
                for (int j = 1; j <= n; ++j) {
                    order -= valid[j];
                    if (order == 0) {
                        ans.append(j);
                        valid[j] = 0;
                        break;
                    }
                }
                k %= factorial[n - i];
            }
            return ans.toString();
        }
    }


    //方法一李为为，采用回溯+剪枝，写的也非常优雅。
    public class Solution {

        /**
         * 记录数字是否使用过
         */
        private boolean[] used;

        /**
         * 阶乘数组
         */
        private int[] factorial;

        private int n;
        private int k;

        public String getPermutation(int n, int k) {
            this.n = n;
            this.k = k;
            calculateFactorial(n);

            // 查找全排列需要的布尔数组
            used = new boolean[n + 1];
            Arrays.fill(used, false);

            StringBuilder path = new StringBuilder();
            dfs(0, path);
            return path.toString();
        }


        /**
         * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
         * @param path
         */
        private void dfs(int index, StringBuilder path) {
            if (index == n) {
                return;
            }

            // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
            int cnt = factorial[n - 1 - index];
            for (int i = 1; i <= n; i++) {
                if (used[i]) {
                    continue;
                }
                if (cnt < k) {
                    k -= cnt;
                    continue;
                }
                path.append(i);
                used[i] = true;
                dfs(index + 1, path);
                // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
                // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
                return;
            }
        }

        /**
         * 计算阶乘数组
         *
         * @param n
         */
        private void calculateFactorial(int n) {
            factorial = new int[n + 1];
            factorial[0] = 1;
            for (int i = 1; i <= n; i++) {
                factorial[i] = factorial[i - 1] * i;
            }
        }
    }

}
