package cn.jjx.coding.leetcode.classification.math_bit;

public class LC372_超级次方 {

    //把LC50看明白了，这道题就很清晰，不过偏数学。
    static final int MOD = 1337;
    public int superPow(int a, int[] b) {
        int ans=1;
        for(int i=b.length-1;i>=0;i--){
            ans=(int)((long)ans*pow(a,b[i])%MOD);
            a=pow(a,10);
        }
        return ans;
    }

    private int pow(int x,int n){
        int res=1;
        while(n!=0){
            if(n%2!=0){
                res=(int)((long)res*x%MOD);
            }
            x=(int)((long)x*x%MOD);
            n/=2;
        }
        return res;
    }
}
