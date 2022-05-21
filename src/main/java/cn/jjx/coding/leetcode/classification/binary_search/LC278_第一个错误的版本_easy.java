package cn.jjx.coding.leetcode.classification.binary_search;

public class LC278_第一个错误的版本_easy {

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    //指定的API并没有给实现的方法
    boolean isBadVersion(int version){
        return true;
    }
}
