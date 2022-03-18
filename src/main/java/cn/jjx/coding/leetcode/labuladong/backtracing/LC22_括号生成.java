package cn.jjx.coding.leetcode.labuladong.backtracing;

import java.util.ArrayList;
import java.util.List;

public class LC22_括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    public void backtrack(List<String> ans,StringBuilder sb,int open,int close,int max){
        if(sb.length()==max*2){
            ans.add(sb.toString());
            return;
        }
        if(open<max){
            sb.append('(');
            backtrack(ans,sb,open+1,close,max);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open){
            sb.append(')');
            backtrack(ans,sb,open,close+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
