package cn.jjx.coding.leetcode.classification.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC785_判断二分图_mid {

    class Solution {
        private static final int UNCOLORED = 0;
        private static final int RED = 1;
        private static final int GREEN = 2;
        private int[] color;
        private boolean valid;

        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            valid = true;
            color = new int[n];
            Arrays.fill(color, UNCOLORED);
            for (int i = 0; i < n && valid; ++i) {
                if (color[i] == UNCOLORED) {
                    dfs(i, RED, graph);
                }
            }
            return valid;
        }

        public void dfs(int node, int c, int[][] graph) {
            color[node] = c;
            int cNei = c == RED ? GREEN : RED;
            for (int neighbor : graph[node]) {
                if (color[neighbor] == UNCOLORED) {
                    dfs(neighbor, cNei, graph);
                    if (!valid) {
                        return;
                    }
                } else if (color[neighbor] != cNei) {
                    valid = false;
                    return;
                }
            }
        }
    }

    class Solution1 {
        private static final int UNCOLORED = 0;
        private static final int RED = 1;
        private static final int GREEN = 2;
        private int[] color;

        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            color = new int[n];
            Arrays.fill(color, UNCOLORED);
            for (int i = 0; i < n; ++i) {
                if (color[i] == UNCOLORED) {
                    Queue<Integer> queue = new LinkedList<Integer>();
                    queue.offer(i);
                    color[i] = RED;
                    while (!queue.isEmpty()) {
                        int node = queue.poll();
                        int cNei = color[node] == RED ? GREEN : RED;
                        for (int neighbor : graph[node]) {
                            if (color[neighbor] == UNCOLORED) {
                                queue.offer(neighbor);
                                color[neighbor] = cNei;
                            } else if (color[neighbor] != cNei) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

}
