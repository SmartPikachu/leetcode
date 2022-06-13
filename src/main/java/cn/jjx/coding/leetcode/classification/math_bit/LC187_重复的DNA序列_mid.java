package cn.jjx.coding.leetcode.classification.math_bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC187_重复的DNA序列_mid {

    class Solution {
        static final int L = 10;

        public List<String> findRepeatedDnaSequences(String s) {
            List<String> ans = new ArrayList<String>();
            Map<String, Integer> cnt = new HashMap<String, Integer>();
            int n = s.length();
            for (int i = 0; i <= n - L; ++i) {
                String sub = s.substring(i, i + L);
                cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
                if (cnt.get(sub) == 2) {
                    ans.add(sub);
                }
            }
            return ans;
        }
    }

    class Solution1 {
        static final int L = 10;
        Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};

        public List<String> findRepeatedDnaSequences(String s) {
            List<String> ans = new ArrayList<String>();
            int n = s.length();
            if (n <= L) {
                return ans;
            }
            int x = 0;
            for (int i = 0; i < L - 1; ++i) {
                x = (x << 2) | bin.get(s.charAt(i));
            }
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int i = 0; i <= n - L; ++i) {
                x = ((x << 2) | bin.get(s.charAt(i + L - 1)))
                        & ((1 << (L * 2)) - 1);
                cnt.put(x, cnt.getOrDefault(x, 0) + 1);
                if (cnt.get(x) == 2) {
                    ans.add(s.substring(i, i + L));
                }
            }
            return ans;
        }
    }

}
