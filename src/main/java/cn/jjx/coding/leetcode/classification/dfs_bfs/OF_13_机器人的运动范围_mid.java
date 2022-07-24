package cn.jjx.coding.leetcode.classification.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class OF_13_机器人的运动范围_mid {

    public int movingCount(int m, int n, int k) {
        if(k==0){
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        //向右和向下的方向数组
        int[] dx = {1,0};
        int[] dy = {0,1};
        queue.offer(new int[]{0,0});
        boolean[][] vis = new boolean[m][n];
        vis[0][0]=true;
        int ans=1;
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x=cell[0],y=cell[1];
            for(int i=0;i<2;i++){
                int tx = dx[i]+x;
                int ty = dy[i]+y;
                if(tx>=m || ty>=n || vis[tx][ty] || get(tx)+get(ty)>k){
                    continue;
                }
                queue.offer(new int[]{tx,ty});
                vis[tx][ty]=true;
                ans++;
            }

        }
        return ans;
    }

    private int get(int x){
        int res=0;
        while(x!=0){
            res+=x%10;
            x/=10;
        }
        return res;
    }

}
