package cn.jjx.coding.leetcode.classification.backtracing;

import java.util.ArrayList;
import java.util.List;

public class LC77_组合_mid {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return ans;
    }

    public void dfs(int cur,int n,int k){
        //剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不
        // 可能构造出长度为 k 的 temp
        if(temp.size()+(n-cur+1)<k){
            return;
        }
        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        //考虑选择当前位置
        temp.add(cur);
        dfs(cur+1,n,k);
        temp.remove(temp.size()-1);
        //考虑不选择当前位置
        dfs(cur+1,n,k);
    }


    //另外一种递归方法
    public List<List<Integer>> combine1(int n, int k) {
        dfs1(1,n,k,new ArrayList<Integer>());
        return ans;
    }

    public void dfs1(int start,int n,int k,List<Integer> list){
        if(k==list.size()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<=n-(k-list.size())+1;i++){
            list.add(i);
            dfs1(i+1,n,k,list);
            list.remove(list.size()-1);
        }
    }

}
