package cn.jjx.coding.leetcode.classification.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC1306_跳跃游戏III_mid {
    //深度优先搜索
    public boolean canReach(int[] arr,int start){
        boolean[] visited = new boolean[arr.length];
        return dfs(arr,start,visited);
    }

    private boolean dfs(int[] arr,int curPos, boolean[] visited){
        if(curPos<0 || curPos>=arr.length || visited[curPos]) return false;
        if(arr[curPos]==0) return true;
        visited[curPos]=true;
        return dfs(arr,curPos-arr[curPos],visited) || dfs(arr,curPos+arr[curPos],visited);
    }

    //广度优先搜索
    public boolean canReach1(int[] arr,int start){
        boolean[] visited = new boolean[arr.length];
        int len = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int curPos = queue.poll();
                if(visited[curPos]) continue;
                if(arr[curPos]==0) return true;
                visited[curPos]=true;
                int left = curPos-arr[curPos];
                if(left>=0 && !visited[left]){
                    queue.offer(left);
                }
                int right=curPos+arr[curPos];
                if(right<len&&!visited[right]){
                    queue.offer(right);
                }
            }
        }
        return false;
    }

}
