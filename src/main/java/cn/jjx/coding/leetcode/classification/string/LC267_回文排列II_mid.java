package cn.jjx.coding.leetcode.classification.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC267_回文排列II_mid {

    //这块是官方题解，写的比较清晰，类似全排列，本质就是全排列。
    public class Solution {

        Set < String > set = new HashSet < > ();
        public List < String > generatePalindromes(String s) {
            int[] map = new int[128];
            char[] st = new char[s.length() / 2];
            if (!canPermutePalindrome(s, map))
                return new ArrayList < > ();
            char ch = 0;
            int k = 0;
            for (int i = 0; i < map.length; i++) {
                if (map[i] % 2 == 1)
                    ch = (char) i;
                for (int j = 0; j < map[i] / 2; j++) {
                    st[k++] = (char) i;
                }
            }
            permute(st, 0, ch);
            return new ArrayList < String > (set);
        }

        //先判断一下是否能产生回文串
        public boolean canPermutePalindrome(String s, int[] map) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i)]++;
                if (map[s.charAt(i)] % 2 == 0)
                    count--;
                else
                    count++;
            }
            return count <= 1;
        }

        //交换字符串
        public void swap(char[] s, int i, int j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        //递归产生回文串
        void permute(char[] s, int l, char ch) {
            if (l == s.length) {
                set.add(new String(s) + (ch == 0 ? "" : ch) + new StringBuffer(new String(s)).reverse());
            } else {
                for (int i = l; i < s.length; i++) {
                    //这块l=i要注意，这是全排列中不交换字符，保持原来顺序。
                    if (s[l] != s[i] || l == i) {
                        swap(s, l, i);
                        permute(s, l + 1, ch);
                        swap(s, l, i);
                    }
                }
            }
        }
    }




}
