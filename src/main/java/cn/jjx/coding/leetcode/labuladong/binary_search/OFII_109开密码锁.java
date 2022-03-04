package cn.jjx.coding.leetcode.labuladong.binary_search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OFII_109开密码锁 {

    public int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for(String str:deadends) deads.add(str);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String cur = queue.poll();

                if(deads.contains(cur)){
                    continue;
                }
                if(target.equals(cur)){
                    return step;
                }

                for(int j=0;j<4;j++){
                    String up = plusOne(cur,j);
                    if(!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down =minusOne(cur,j);
                    if(!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;

        }

        return -1;

    }

    public String plusOne(String s, int j){
        char[] chars = s.toCharArray();
        if(chars[j] == '9'){
            chars[j]='0';
        }else{
            chars[j]=(char)(chars[j]+1);
        }
        return new String(chars);
    }

    public String minusOne(String s, int j){
        char[] chars = s.toCharArray();
        if(chars[j] == '0'){
            chars[j] = '9';
        }else{
            chars[j] = (char)(chars[j]-1);
        }
        return new String(chars);
    }
}
