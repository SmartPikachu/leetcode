package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.ArrayDeque;

public class LC449_序列化和反序列化二叉搜索树_mid {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = postorder(root,new StringBuilder());
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for(String s:data.split("\\s+")){
            nums.add(Integer.valueOf(s));
        }
        return helper(Integer.MIN_VALUE,Integer.MAX_VALUE,nums);
    }

    public StringBuilder postorder(TreeNode root,StringBuilder sb){
        if(root==null) return sb;
        postorder(root.left,sb);
        postorder(root.right,sb);
        sb.append(root.val);
        sb.append(' ');
        return sb;
    }

    public TreeNode helper(Integer lower, Integer upper,
                           ArrayDeque<Integer> nums){
        if(nums.isEmpty()){
            return null;
        }
        int val = nums.getLast();
        if(val<lower||val>upper){
            return null;
        }
        nums.removeLast();
        TreeNode root = new TreeNode(val);
        //这块一定要注意下，先右孩子，然后左孩子
        root.right=helper(val,upper,nums);
        root.left=helper(lower,val,nums);
        return root;
    }
}
