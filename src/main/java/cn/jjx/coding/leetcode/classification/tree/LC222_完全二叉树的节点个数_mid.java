package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

public class LC222_完全二叉树的节点个数_mid {

    /**
     * 再来回顾一下满二叉的节点个数怎么计算，如果满二叉树的层数为h，则总节点数为：2^h - 1.
     *left == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，左子树必定已经填满了。
     * 所以左子树的节点总数我们可以直接得到，是 2^left - 1，加上当前这个 root 节点，则正好是 2^left。再对右子树进行递归统计。
     *left != right。说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。
     * 同理，右子树节点 +root 节点，总数为 2^right。再对左子树进行递归查找。
     */

    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=countLevel(root.left);
        int right=countLevel(root.right);
        if(left==right){
            return countNodes(root.right)+(1<<left);
        }else{
            return countNodes(root.left)+(1<<right);
        }

    }

    public int countLevel(TreeNode node){
        int level=0;
        while(node!=null){
            level++;
            node=node.left;
        }
        return level;
    }
}
