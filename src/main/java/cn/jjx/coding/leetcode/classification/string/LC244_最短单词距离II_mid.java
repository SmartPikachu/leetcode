package cn.jjx.coding.leetcode.classification.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC244_最短单词距离II_mid {

    class WordDistance {
        Map<String, List<Integer>> indicesMap =
                new HashMap<String, List<Integer>>();

        public WordDistance(String[] wordsDict) {
            int length = wordsDict.length;
            for (int i = 0; i < length; i++) {
                String word = wordsDict[i];
                indicesMap.putIfAbsent(word, new ArrayList<Integer>());
                indicesMap.get(word).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> indices1 = indicesMap.get(word1);
            List<Integer> indices2 = indicesMap.get(word2);
            int size1 = indices1.size(), size2 = indices2.size();
            int pos1 = 0, pos2 = 0;
            int ans = Integer.MAX_VALUE;
            while (pos1 < size1 && pos2 < size2) {
                int index1 = indices1.get(pos1), index2 = indices2.get(pos2);
                ans = Math.min(ans, Math.abs(index1 - index2));
                if (index1 < index2) {
                    pos1++;
                } else {
                    pos2++;
                }
            }
            return ans;
        }
    }



}
