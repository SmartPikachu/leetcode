package cn.jjx.coding.leetcode.classification.sort;

import java.util.*;

public class LC451_根据字符出现频率排序 {

    //桶排序的方法
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int length = s.length();
        for(int i=0;i<length;i++){
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c,0)+1;
            map.put(c,frequency);
            maxFreq=Math.max(maxFreq,frequency);
        }
        StringBuffer[] buckets = new StringBuffer[maxFreq+1];
        for(int i=0;i<=maxFreq;i++){
            buckets[i]=new StringBuffer();
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=maxFreq;i>0;i--){
            StringBuffer bucket = buckets[i];
            int size = bucket.length();
            for(int j=0;j<size;j++){
                for(int k=0;k<i;k++){
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }

    //按照出现频率排序
    public String frequencySort1(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
