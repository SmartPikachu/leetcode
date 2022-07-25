package cn.jjx.coding.leetcode.classification.divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

public class LC241_为运算表达式设计优先级_mid {

    /**
     * 分治法，下面的题解是非常优雅的，不求多种解法，选出一种适合自己的就可以了。
     *这种解法有个前提条件是表达式里的数字都是正数，不过提示已经声明，都是正数。
     *如果包含负数和零，则下面的方法不行。下面题解是官方题解评论区找到的一个解法
     */

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        int len = expression.length();
        int start = 0;
        for (start = 0; start < len; start++) {
            //找到一个运算符
            if (!Character.isDigit(expression.charAt(start))) {
                break;
            }
        }
        //没找到等于字符串里没有运算符，那直接返回对应数字结果
        if(start==len) list.add(Integer.parseInt(expression));

        for (int i = start; i < len; i++) {
            if(Character.isDigit(expression.charAt(i))) continue;
            char op = expression.charAt(i);
            //用该运算符分隔成 左边的字符串 和 右边的字符串
            //左边的字符串再递归继续求得 数字结果集
            List<Integer> left = diffWaysToCompute(expression.substring(0,i));
            //右边的字符串再递归继续求得 数字结果集
            List<Integer> right = diffWaysToCompute(expression.substring(i+1,len));

            //从左右两个求得数字结果集里拿出数字，基于当前运算符运算完 ，添加进最终list，得到最终数字结果集
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
