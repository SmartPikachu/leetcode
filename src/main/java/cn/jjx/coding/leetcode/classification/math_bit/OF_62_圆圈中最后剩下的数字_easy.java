package cn.jjx.coding.leetcode.classification.math_bit;

public class OF_62_圆圈中最后剩下的数字_easy {

    class Solution {
        public int lastRemaining(int n, int m) {
            return f(n, m);
        }

        public int f(int n, int m) {
            if (n == 1) {
                return 0;
            }
            int x = f(n - 1, m);
            return (m + x) % n;
        }
    }

    class Solution1 {
        public int lastRemaining(int n, int m) {
            int f = 0;
            for (int i = 2; i != n + 1; ++i) {
                f = (m + f) % i;
            }
            return f;
        }
    }

}
