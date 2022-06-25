package cn.jjx.coding.leetcode.classification.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC373_查找和最小的K对数字_mid {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->
            nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]
        );
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i,0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            //这块要注意了，其实是(0,1)-(0,n)
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }

        return ans;
    }


}
