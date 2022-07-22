package cn.jjx.coding.leetcode.classification.dfs_bfs.拓扑排序;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC207_课程表_mid {

    /**
     * 拓扑排序，深度优先方法
     * 「未搜索」：我们还没有搜索到这个节点；
     * 「搜索中」：我们搜索过这个节点，但还没有回溯到该节点，即该节点还没有入栈，
     * 还有相邻的节点没有搜索完成）；
     * 「已完成」：我们搜索过并且回溯过这个节点，即该节点已经入栈，
     * 并且所有该节点的相邻节点都出现在栈的更底部的位置，满足拓扑排序的要求。
     */

    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses,int[][] prerequisites){
        edges = new ArrayList<List<Integer>>();
        for(int i=0;i<numCourses;i++){
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for(int[] info:prerequisites){
            edges.get(info[1]).add(info[0]);
        }
        for(int i=0;i<numCourses&&valid;i++){
            if(visited[i]==0){
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u){
        visited[u] = 1;
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
    }


    //广度优先搜索,把入度为0的节点放到队列，然后BFS，最终队列中是n个节点说明没有环。
    class Solution {
        List<List<Integer>> edges;
        int[] indeg;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            indeg = new int[numCourses];
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                ++indeg[info[0]];
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            for (int i = 0; i < numCourses; ++i) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }

            int visited = 0;
            while (!queue.isEmpty()) {
                ++visited;
                int u = queue.poll();
                for (int v: edges.get(u)) {
                    --indeg[v];
                    if (indeg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }

            return visited == numCourses;
        }
    }

}
