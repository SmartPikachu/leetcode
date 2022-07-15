package cn.jjx.coding.leetcode.classification.array.模拟;

public class LC277_搜寻名人_mid {

    //感觉这道题意义不大，就是两次循环。
    public int findCelebrity(int n) {

        //首先先循环一次，求出所有人都认识的那个人。
        int ans = 0;
        for(int k = 0; k < n; k++){
            if(knows(ans, k)){
                ans = k;
            }
        }

        //然后在循环一次，来验证一下所求的名人是否合理。
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
