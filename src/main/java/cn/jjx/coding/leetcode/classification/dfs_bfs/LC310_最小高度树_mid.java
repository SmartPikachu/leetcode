package cn.jjx.coding.leetcode.classification.dfs_bfs;

import java.util.*;

public class LC310_最小高度树_mid {

    //拓扑排序方法最优，首先找到所有度为1的节点压入队列，此时令节点剩余计数remainNodes=n；
    //同时将当前remainNodes计数减去出度为1的节点数目，将最外层的度为1的叶子节点取出，
    //并将与之相邻的节点的度减少，重复上述步骤将当前节点中度为1的节点压入队列中；
    //重复上述步骤，直到剩余的节点数组remainNodes≤2 时，此时剩余的节点即为当前高度最小树的根节点。
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> ans = new ArrayList<Integer>();
            if (n == 1) {
                ans.add(0);
                return ans;
            }
            int[] degree = new int[n];
            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<Integer>();
            }
            for (int[] edge : edges) {
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
                degree[edge[0]]++;
                degree[edge[1]]++;
            }
            Queue<Integer> queue = new ArrayDeque<Integer>();
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) {
                    queue.offer(i);
                }
            }
            int remainNodes = n;
            while (remainNodes > 2) {
                int sz = queue.size();
                remainNodes -= sz;
                for (int i = 0; i < sz; i++) {
                    int curr = queue.poll();
                    for (int v : adj[curr]) {
                        degree[v]--;
                        if (degree[v] == 1) {
                            queue.offer(v);
                        }
                    }
                }
            }
            while (!queue.isEmpty()) {
                ans.add(queue.poll());
            }
            return ans;
        }
    }


    //方法一，广度优先搜索，不过需要证明最小路径一定是最大路径一半。
    //首先找到距离节点0的最远节点x，然后找到距离节点x的最远节点y，
    // 然后找到节点x与节点y的路径，然后找到根节点。
    class Solution1 {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> ans = new ArrayList<Integer>();
            if (n == 1) {
                ans.add(0);
                return ans;
            }
            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<Integer>();
            }
            for (int[] edge : edges) {
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }

            int[] parent = new int[n];
            Arrays.fill(parent, -1);
            /* 找到与节点 0 最远的节点 x */
            int x = findLongestNode(0, parent, adj);
            /* 找到与节点 x 最远的节点 y */
            int y = findLongestNode(x, parent, adj);
            /* 求出节点 x 到节点 y 的路径 */
            List<Integer> path = new ArrayList<Integer>();
            parent[x] = -1;
            while (y != -1) {
                path.add(y);
                y = parent[y];
            }
            int m = path.size();
            if (m % 2 == 0) {
                ans.add(path.get(m / 2 - 1));
            }
            ans.add(path.get(m / 2));
            return ans;
        }

        public int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
            int n = adj.length;
            Queue<Integer> queue = new ArrayDeque<Integer>();
            boolean[] visit = new boolean[n];
            queue.offer(u);
            visit[u] = true;
            int node = -1;

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                node = curr;
                for (int v : adj[curr]) {
                    if (!visit[v]) {
                        visit[v] = true;
                        parent[v] = curr;
                        queue.offer(v);
                    }
                }
            }
            return node;
        }
    }

    //利用深度优先搜索
    class Solution2 {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> ans = new ArrayList<Integer>();
            if (n == 1) {
                ans.add(0);
                return ans;
            }
            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<Integer>();
            }
            for (int[] edge : edges) {
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }

            int[] parent = new int[n];
            Arrays.fill(parent, -1);
            /* 找到与节点 0 最远的节点 x */
            int x = findLongestNode(0, parent, adj);
            /* 找到与节点 x 最远的节点 y */
            int y = findLongestNode(x, parent, adj);
            /* 求出节点 x 到节点 y 的路径 */
            List<Integer> path = new ArrayList<Integer>();
            parent[x] = -1;
            while (y != -1) {
                path.add(y);
                y = parent[y];
            }
            int m = path.size();
            if (m % 2 == 0) {
                ans.add(path.get(m / 2 - 1));
            }
            ans.add(path.get(m / 2));
            return ans;
        }

        public int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
            int n = adj.length;
            int[] dist = new int[n];
            Arrays.fill(dist, -1);
            dist[u] = 0;
            dfs(u, dist, parent, adj);
            int maxdist = 0;
            int node = -1;
            for (int i = 0; i < n; i++) {
                if (dist[i] > maxdist) {
                    maxdist = dist[i];
                    node = i;
                }
            }
            return node;
        }

        public void dfs(int u, int[] dist, int[] parent, List<Integer>[] adj) {
            for (int v : adj[u]) {
                if (dist[v] < 0) {
                    dist[v] = dist[u] + 1;
                    parent[v] = u;
                    dfs(v, dist, parent, adj);
                }
            }
        }
    }

}
