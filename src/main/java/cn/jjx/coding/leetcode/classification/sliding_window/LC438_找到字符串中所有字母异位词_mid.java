package cn.jjx.coding.leetcode.classification.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438_找到字符串中所有字母异位词_mid {

    public List<Integer> findAnagrams(String s, String p) {
        int sLen=s.length(),pLen=p.length();
        if(sLen<pLen){
            return new ArrayList<>();
        }
        int[] sCount=new int[26];
        int[] pCount=new int[26];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<pLen;i++){
            sCount[s.charAt(i)-'a']++;
            pCount[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(sCount,pCount)){
            ans.add(0);
        }
        for(int i=0;i<sLen-pLen;i++){
            sCount[s.charAt(i)-'a']--;
            sCount[s.charAt(i+pLen)-'a']++;
            if(Arrays.equals(sCount,pCount)){
                ans.add(i+1);
            }
        }
        return ans;

    }
}
