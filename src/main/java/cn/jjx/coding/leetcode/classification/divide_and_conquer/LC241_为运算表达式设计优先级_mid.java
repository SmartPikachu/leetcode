package cn.jjx.coding.leetcode.classification.divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

public class LC241_为运算表达式设计优先级_mid {

    //这种解法有个前提条件是表达式里的数字都是正数，不过提示已经声明，都是正数。
    //如果包含负数和零，则下面的方法不行。
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        int len = expression.length();
        int start = 0;
        for (start = 0; start < len; start++) {
            if(Character.isDigit(expression.charAt(start))) continue;
            else break;
        }
        if(start==len) list.add(Integer.parseInt(expression));
        for (int i = start; i < len; i++) {
            if(Character.isDigit(expression.charAt(i))) continue;
            char op = expression.charAt(i);
            List<Integer> left = diffWaysToCompute(expression.substring(0,i));
            List<Integer> right = diffWaysToCompute(expression.substring(i+1,len));
            for (int j : left){
                for (int k : right){
                    if(op=='+') list.add(j+k);
                    else if(op == '-') list.add(j-k);
                    else if(op == '*') list.add(j*k);
                }
            }
        }
        return list;
    }
}
