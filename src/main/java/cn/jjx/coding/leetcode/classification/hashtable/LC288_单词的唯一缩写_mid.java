package cn.jjx.coding.leetcode.classification.hashtable;

import java.util.*;

public class LC288_单词的唯一缩写_mid {

    class ValidWordAbbr {
        private final Map<String, Boolean> abbrDict = new HashMap<>();
        private final Set<String> dict;

        public ValidWordAbbr(String[] dictionary) {
            dict = new HashSet<>(Arrays.asList(dictionary));
            for (String s : dict) {
                String abbr = toAbbr(s);
                abbrDict.put(abbr, !abbrDict.containsKey(abbr));
            }
        }

        public boolean isUnique(String word) {
            String abbr = toAbbr(word);
            Boolean hasAbbr = abbrDict.get(abbr);
            return hasAbbr == null || (hasAbbr && dict.contains(word));
        }

        private String toAbbr(String s) {
            int n = s.length();
            if (n <= 2) {
                return s;
            }
            return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
        }
    }

    class ValidWordAbbr1 {
        private final Map<String, Set<String>> abbrDict = new HashMap<>();

        public ValidWordAbbr1(String[] dictionary) {
            for (String s : dictionary) {
                String abbr = toAbbr(s);
                Set<String> words = abbrDict.containsKey(abbr)
                        ? abbrDict.get(abbr) : new HashSet<>();
                words.add(s);
                abbrDict.put(abbr, words);
            }
        }

        public boolean isUnique(String word) {
            String abbr = toAbbr(word);
            Set<String> words = abbrDict.get(abbr);
            return words == null || (words.size() == 1 && words.contains(word));
        }

        private String toAbbr(String s) {
            int n = s.length();
            if (n <= 2) {
                return s;
            }
            return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
        }
    }


}
