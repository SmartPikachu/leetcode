package cn.jjx.coding.leetcode.classification.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LC772_基本计算器III {

    private int index = 0;
    public int calculate(String s) {
        char[] ch = s.toCharArray();
        return calculateHelper(ch);

    }
    private int calculateHelper(char[] ch){
        Deque<Integer> stack = new LinkedList<>();
        int num=0;
        char sign='+';
        for(;index<ch.length;index++){
            char c=ch[index];
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }
            if(c=='('){
                index++;//index指针指到下一个字符
                num=calculateHelper(ch);
            }
            //当遇到了新的运算符，就要对上一个运算符sign和累计的数字num作运算
            if(!Character.isDigit(c)&&c!=' ' || index==ch.length-1){
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                sign=c;
                num=0;
            }
            if(c==')') break;
        }
        int res=0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
