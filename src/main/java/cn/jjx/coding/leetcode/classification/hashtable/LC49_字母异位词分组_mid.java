package cn.jjx.coding.leetcode.classification.hashtable;

import java.util.*;

public class LC49_字母异位词分组_mid {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map  = new HashMap<>();
        for(String str:strs){
            int[] counts = new int[26];
            int length = str.length();
            for(int i=0;i<length;i++){
                counts[str.charAt(i)-'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<26;i++){
                if(counts[i]!=0){
                    sb.append((char)('a'+i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key,new ArrayList<String >());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    //直接把排序好的单词作为键，这样代码感觉会简洁
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
