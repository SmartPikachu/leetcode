package cn.jjx.coding.leetcode.labuladong.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC354_俄罗斯套娃信封 {

    /**
     * 这种方法会超时，但是思路清晰,时间复杂度n^2,空间复杂度n
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0){
            return 0;
        }
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0]-o2[0];
                }else{
                    return o2[1]-o1[1];
                }
            }
        });

        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int ans = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(envelopes[j][1]<envelopes[i][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;

    }


    /**
     * 下面的方法基于二分法复杂度是nlogn,空间复杂度为n,这种方法比较难想
     * @param envelopes
     * @return
     */
    public int maxEnvelopes1(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        List<Integer> f = new ArrayList<Integer>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


}
