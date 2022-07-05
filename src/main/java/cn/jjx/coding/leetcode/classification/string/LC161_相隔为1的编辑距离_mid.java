package cn.jjx.coding.leetcode.classification.string;

public class LC161_相隔为1的编辑距离_mid {

    //看22年最新的题解，本身这个代码已经足够清晰了。
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (n - m == 1) {
            return isOneInsert(s, t);
        } else if (m - n == 1) {
            return isOneInsert(t, s);
        } else if (m == n) {
            boolean foundDifference = false;
            for (int i = 0; i < m; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (!foundDifference) {
                        foundDifference = true;
                    } else {
                        return false;
                    }
                }
            }
            return foundDifference;
        } else {
            return false;
        }
    }

    public boolean isOneInsert(String shorter, String longer) {
        int length1 = shorter.length(), length2 = longer.length();
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            if (shorter.charAt(index1) == longer.charAt(index2)) {
                index1++;
            }
            index2++;
            if (index2 - index1 > 1) {
                return false;
            }
        }
        return true;
    }

}
