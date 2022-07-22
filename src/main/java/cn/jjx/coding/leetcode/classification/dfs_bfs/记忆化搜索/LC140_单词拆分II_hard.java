package cn.jjx.coding.leetcode.classification.dfs_bfs.记忆化搜索;

import java.util.*;

public class LC140_单词拆分II_hard {

    //记忆化搜索
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map =
                new HashMap<Integer, List<List<String>>>();
        List<List<String>> wordBreaks = backtrack(s, s.length(),
                new HashSet<>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrack(String s, int length,
          Set<String> wordSet, int index,
          Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
            if (index == length) {
                wordBreaks.add(new LinkedList<>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks =
                            backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak =
                                new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }
}
