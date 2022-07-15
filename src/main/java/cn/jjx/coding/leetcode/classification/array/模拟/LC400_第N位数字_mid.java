package cn.jjx.coding.leetcode.classification.array.模拟;

public class LC400_第N位数字_mid {

    //官方题解一，采用二分法。需要找到规律，列出表达式
    class Solution {
        public int findNthDigit(int n) {
            int low = 1, high = 9;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (totalDigits(mid) < n) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            int d = low;
            int prevDigits = totalDigits(d - 1);
            int index = n - prevDigits - 1;
            int start = (int) Math.pow(10, d - 1);
            int num = start + index / d;
            int digitIndex = index % d;
            int digit = (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
            return digit;
        }

        public int totalDigits(int length) {
            int digits = 0;
            int curLength = 1, curCount = 9;
            while (curLength <= length) {
                digits += curLength * curCount;
                curLength++;
                curCount *= 10;
            }
            return digits;
        }
    }


    //官方题解二，采用直接计算的方法，必须要找到规律，列出表达式才能解出来.
    //代码是真的简洁优美，思路是真的难想
    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }
}
