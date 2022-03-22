package cn.jjx.coding.leetcode.classification.union_find;

public class UnionFind {
    /**
     * 关于并查集的详细介绍可以看 https://labuladong.gitee.io/algo/2/20/41/
     * 里面有譬如路径压缩的解释
     */

    //连通分量的个数
    private int count;

    //储存每个节点的父节点
    private int[] parent;

    //记录每棵树的重量
    private int[] size;

    public UnionFind(int n){
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP==rootQ) return;
        //小树接在大树下面，较平衡
        if(size[rootP]>size[rootQ]){
            parent[rootQ]=rootP;
            size[rootP]+=size[rootQ];
        }else{
            parent[rootP]=rootQ;
            size[rootQ]+=size[rootP];
        }
        count--;
    }

    public boolean connected(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP==rootQ;
    }

    private int find(int x){
        while(parent[x]!=x){
            //进行路径压缩
            parent[x]=parent[parent[x]];
            x=parent[x];
        }
        return x;
    }

    public int count(){
        return count;
    }

}
