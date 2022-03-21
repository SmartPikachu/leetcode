package cn.jjx.coding.leetcode.labuladong.binary_search;

public class LC875_爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 1_000_000_000;
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(!possible(piles,h,mid)){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        return lo;
    }

    public boolean possible(int[] piles,int H,int K){
        int time = 0;
        for(int p:piles){
            time+=(p-1)/K+1;
        }
        return time<= H;
    }
}
