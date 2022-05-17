package cn.jjx.coding.leetcode.classification.array;

public class LC277_搜寻名人_mid {

    public int findCelebrity(int n) {
        int ans = 0;
        for(int k = 0; k < n; k++){
            if(knows(ans, k)){
                ans = k;
            }
        }

        for(int k = 0; k < n; k++){
            if(k != ans){
                if(!knows(k, ans)){
                    return -1;
                }
                if(knows(ans, k)){
                    return -1;
                }
            }
        }
        return ans;
    }

    public boolean knows(int i,int j){
        //没有实现
        return true;
    }
}
