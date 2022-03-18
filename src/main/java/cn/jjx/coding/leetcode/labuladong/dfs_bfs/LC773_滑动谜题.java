package cn.jjx.coding.leetcode.labuladong.dfs_bfs;

import java.util.*;

public class LC773_滑动谜题 {

    int[][] neighbors = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();
        if("123450".equals(initial)){
            return 0;
        }
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(initial);
        Set<String> seen =  new HashSet<>();
        seen.add(initial);

        while(!queue.isEmpty()){
            step++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                String status = queue.poll();
                for(String nextStatus:get(status)){
                    if(!seen.contains(nextStatus)){
                        if("123450".equals(nextStatus)){
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        return -1;

    }


    // 枚举 status 通过一次交换操作得到的状态
    public List<String> get(String status){
        List<String> ret = new ArrayList<>();
        char[] array= status.toCharArray();
        int x = status.indexOf('0');
        for(int y:neighbors[x]){
           swap(array,x,y);
           ret.add(new String(array));
           swap(array,x,y);
        }
        return ret;
    }

    public void swap(char[] array,int x,int y){
        char temp = array[x];
        array[x]=array[y];
        array[y]=temp;
    }
}
