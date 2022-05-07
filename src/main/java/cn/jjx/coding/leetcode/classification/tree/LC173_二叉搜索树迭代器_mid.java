package cn.jjx.coding.leetcode.classification.tree;

import cn.jjx.coding.leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC173_二叉搜索树迭代器_mid {

    class BSTIterator {
        private int idx;
        private List<Integer> list;

        public BSTIterator(TreeNode root) {
            idx=0;
            list=new ArrayList<>();
            inorderTraversal(root,list);
        }

        public int next() {
            return list.get(idx++);
        }

        public boolean hasNext() {
            return idx<list.size();
        }

        public void inorderTraversal(TreeNode root,List<Integer> list){
            if(root==null) return;
            inorderTraversal(root.left,list);
            list.add(root.val);
            inorderTraversal(root.right,list);
        }
    }

    //迭代的方法
    class BSTIterator1{
        private TreeNode cur;
        private Deque<TreeNode> stack;

        public BSTIterator1(TreeNode root) {
            cur=root;
            stack=new LinkedList<>();
        }

        public int next() {
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            int ret=cur.val;
            cur=cur.right;
            return ret;
        }

        public boolean hasNext() {
            return cur!=null||!stack.isEmpty();
        }

    }
}
