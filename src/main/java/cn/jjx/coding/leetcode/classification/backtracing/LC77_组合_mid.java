package cn.jjx.coding.leetcode.classification.backtracing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC77_组合_mid {

    //官方题解一
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



    //李为为方法四，代码很优雅指定参考。
    public class Solution {

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0 || n < k) {
                return res;
            }

            // 为了防止底层动态数组扩容，初始化的时候传入最大长度
            Deque<Integer> path = new ArrayDeque<>(k);
            dfs(1, n, k, path, res);
            return res;
        }

        private void dfs(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
            if (k == 0) {
                res.add(new ArrayList<>(path));
                return;
            }

            // 基础版本的递归终止条件：if (begin == n + 1) {
            if (begin > n - k + 1) {
                return;
            }
            // 不选当前考虑的数 begin，直接递归到下一层
            dfs(begin + 1, n, k, path, res);

            // 不选当前考虑的数 begin，递归到下一层的时候 k - 1，这里 k 表示还需要选多少个数
            path.addLast(begin);
            dfs(begin + 1, n, k - 1, path, res);
            // 深度优先遍历有回头的过程，因此需要撤销选择
            path.removeLast();
        }
    }

}
