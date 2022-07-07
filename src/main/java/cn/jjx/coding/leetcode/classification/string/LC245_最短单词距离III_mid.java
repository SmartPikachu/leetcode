package cn.jjx.coding.leetcode.classification.string;

public class LC245_最短单词距离III_mid {

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int length = wordsDict.length;
        int ans = length;
        if (word1.equals(word2)) {
            int prev = -1;
            for (int i = 0; i < length; i++) {
                String word = wordsDict[i];
                if (word.equals(word1)) {
                    if (prev >= 0) {
                        ans = Math.min(ans, i - prev);
                    }
                    prev = i;
                }
            }
        } else {
            int index1 = -1, index2 = -1;
            for (int i = 0; i < length; i++) {
                String word = wordsDict[i];
                if (word.equals(word1)) {
                    index1 = i;
                } else if (word.equals(word2)) {
                    index2 = i;
                }
                if (index1 >= 0 && index2 >= 0) {
                    ans = Math.min(ans, Math.abs(index1 - index2));
                }
            }
        }
        return ans;
    }

}
