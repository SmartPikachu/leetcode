package cn.jjx.coding.leetcode.classification.graph.前缀树;

import java.util.HashMap;
import java.util.Map;

public class LC820_单词的压缩编码_mid {

    //这道题其实是储存后缀，然后把最长的后缀和累加，最长的后缀的count=0;
    class Solution {
        public int minimumLengthEncoding(String[] words) {
            TrieNode trie = new TrieNode();
            Map<TrieNode, Integer> nodes = new HashMap<TrieNode, Integer>();

            for (int i = 0; i < words.length; ++i) {
                String word = words[i];
                TrieNode cur = trie;
                for (int j = word.length() - 1; j >= 0; --j) {
                    cur = cur.get(word.charAt(j));
                }
                nodes.put(cur, i);
            }

            int ans = 0;
            for (TrieNode node: nodes.keySet()) {
                if (node.count == 0) {
                    ans += words[nodes.get(node)].length() + 1;
                }
            }
            return ans;

        }
    }

    class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }

        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }

}
