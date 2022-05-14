package cn.jjx.coding.leetcode.classification.graph.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC128_最长连续序列_mid {

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }



    public int longestConsecutive1(int[] nums) {
        UnionFind uf = new UnionFind(nums);
        int ans = 0;

        for (int num : nums) {
            // 当num+1存在，将num合并到num+1所在集合中
            if (uf.find(num + 1) != null) {
                uf.union(num, num + 1);
            }
        }

        for (int num : nums) {
            // 找到num的最远连续右边界
            int right = uf.find(num);
            ans = Math.max(ans, right - num + 1);
        }
        return ans;
    }


    class UnionFind {
        // 记录每个节点的父节点
        private Map<Integer, Integer> parent;

        public UnionFind(int[] nums) {
            parent = new HashMap<>();
            // 初始化父节点为自身
            for (int num : nums) {
                parent.put(num, num);
            }
        }

        // 寻找x的父节点，实际上也就是x的最远连续右边界，这点类似于方法2
        public Integer find(int x) {
            // nums不包含x
            if (!parent.containsKey(x)) {
                return null;
            }
            // 遍历找到x的父节点
            while (x != parent.get(x)) {
                // 进行路径压缩，不写下面这行也可以，但是时间会慢些
                parent.put(x, parent.get(parent.get(x)));
                x = parent.get(x);
            }
            return x;
        }

        // 合并两个连通分量，在本题中只用来将num并入到num+1的连续区间中
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent.put(rootX, rootY);
        }
    }


}
