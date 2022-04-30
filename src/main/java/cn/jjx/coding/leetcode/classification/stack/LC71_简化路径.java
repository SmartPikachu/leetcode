package cn.jjx.coding.leetcode.classification.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC71_简化路径 {

    //使用deque这个双端队列，这个deque实现了queue接口
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String name:names){
            if("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            }else if(name.length()>0 && !".".equals(name)){
                    stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if(stack.isEmpty()){
            ans.append('/');
        }else{
            while(!stack.isEmpty()){
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }

}
