package cn.jjx.coding.leetcode.classification.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC210_课程表II {
    List<List<Integer>> edges;
    int[] visited;
    int[] result;
    boolean valid = true;
    int index;

    public int[] findOrder(int numCourses,int[][] prerequisites){
        edges = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            edges.add(new ArrayList<Integer>());
        }
        visited=new int[numCourses];
        result=new int[numCourses];
        index=numCourses-1;
        for(int[] info:prerequisites){
            edges.get(info[1]).add(info[0]);
        }
        for(int i=0;i<numCourses&&valid;i++){
            if(visited[i]==0){
                dfs(i);
            }
        }
        if(!valid){
            return new int[0];
        }
        return result;
    }

    public void dfs(int u){
        visited[u]=1;
        for(int v:edges.get(u)){
            if(visited[v]==0){
                dfs(v);
                if(!valid){
                    return;
                }
            }else if(visited[v]==1){
                valid=false;
                return;
            }
        }
        visited[u]=2;
        result[index--]=u;
    }

    //广度优先搜索拓扑排序
    int[] indeg;
    public int[] findOrder1(int numCourses,int[][] prerequisites){
        edges = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            edges.add(new ArrayList<Integer>());
        }
        indeg=new int[numCourses];
        result=new int[numCourses];
        index=0;
        for(int[] info:prerequisites){
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int u = queue.poll();
            result[index++]=u;
            for(int v:edges.get(u)){
                indeg[v]--;
                if(indeg[v]==0){
                    queue.offer(v);
                }
            }
        }
        if(index!=numCourses){
            return new int[0];
        }
        return result;
    }
}
