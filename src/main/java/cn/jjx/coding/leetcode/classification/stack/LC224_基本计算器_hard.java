package cn.jjx.coding.leetcode.classification.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LC224_基本计算器_hard {

    public int calculate(String s) {
        //这里注意LinkedList和ArrayDeque都分别实现了Deque接口
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign=1;
        int ret=0;
        int n= s.length();
        int i = 0;
        while(i<n){
            if(s.charAt(i)==' '){
                i++;
            }else if(s.charAt(i)=='+'){
                sign=ops.peek();
                i++;
            }else if(s.charAt(i)=='-'){
                sign=-ops.peek();
                i++;
            }else if(s.charAt(i)=='('){
                ops.push(sign);
                i++;
            }else if(s.charAt(i)==')'){
                ops.pop();
                i++;
            }else{
                long num=0;
                while(i<n&&Character.isDigit(s.charAt(i))){
                    num=num*10+s.charAt(i)-'0';
                    i++;
                }
                ret+=sign*num;
            }
        }
        return ret;

    }
}
