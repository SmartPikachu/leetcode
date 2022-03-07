package cn.jjx.coding.leetcode.labuladong.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LC3_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int rk=-1,ans=0;
        for(int i=0;i<n;i++){
            if(i!=0){
                occ.remove(s.charAt(i-1));
            }
            while(rk+1<n&&!occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                rk++;
            }
            ans=Math.max(ans,rk-i+1);
        }
        return ans;
    }

}
