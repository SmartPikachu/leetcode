package cn.jjx.coding.leetcode.classification.string.KMP;

public class KMP {

    /**
     * 具体参考代码随想录的讲解
     * https://leetcode-cn.com/problems/implement-strstr/solution/dai-ma-sui-xiang-lu-kmpsuan-fa-xiang-jie-mfbs/
     */


    /**
     * 注意这里是给的前缀表减一情况的求前缀数组的方法，比较常用
     * @param s
     * @return
     */
    public int[] getNext(String s){
        int n = s.length();
        int[] next = new int[n];
        int j=-1;
        next[0]=j;
        //注意i要从1开始
        for(int i=1;i<n;i++){
            //前后缀不相同
            while(j>=0 && s.charAt(i)!=s.charAt(j+1)){
    //向前回退，这块只用用纸模拟一下就清晰，本质j就是从右到左，i也是从右到左
                j=next[j];
            }
            if(s.charAt(i)==s.charAt(j+1)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }


    /**
     * 注意这里是给的前缀表不减一的求前缀数组的方法
     * @param s
     * @return
     */
    public int[] getNext1(String s){
        int n = s.length();
        int[] next = new int[n];
        int j=0;
        next[0]=j;
        for(int i=1;i<n;i++){
            while(j>=0 && s.charAt(i)!=s.charAt(j)){
                j=next[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
