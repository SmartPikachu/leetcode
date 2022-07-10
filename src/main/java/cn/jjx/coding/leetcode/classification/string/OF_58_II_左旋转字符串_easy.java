package cn.jjx.coding.leetcode.classification.string;

public class OF_58_II_左旋转字符串_easy {

    //方法一，采用模拟的方法
    public boolean rotateString(String s, String goal) {
        int m = s.length(), n = goal.length();
        if (m != n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (s.charAt((i + j) % n) != goal.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }


    //方法二搜索子字符串
    public boolean rotateString1(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }


}
