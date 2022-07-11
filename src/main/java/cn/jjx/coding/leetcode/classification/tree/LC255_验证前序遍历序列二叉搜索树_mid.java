package cn.jjx.coding.leetcode.classification.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LC255_验证前序遍历序列二叉搜索树_mid {

    /**
     *先序遍历，如果递减，一定是左子树；
     * 如果出现非递减的值，意味着到了某个节点的右子树；
     * 利用栈来寻找该节点，最后一个比当前元素小的从栈弹出的元素即为该节点的父亲节点，而且当前元素父节点即为新的下限值；
     * 后续的元素一定是比当前的下限值要大的，否则return false；
     */
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack();
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < min) return false;
            while (!stack.isEmpty() && preorder[i]>stack.peek()){
                min = stack.pop();
            }
            stack.push(preorder[i]);
        }
        return true;
    }


    //下面这种方法效率比较高，接近100%。
    // 用单调栈的方式，递减栈，当碰到一个数比栈顶元素大的时候，说明从左子树到了右子树。
    // 此时要删掉左子树的所有节点，并且保留子树的根为最小值，此时遍历的所有右子树的节点都必须大于这个根，否则非法
    public boolean verifyPreorder1(int[] preorder) {
        int len = preorder.length;
        int[] stack = new int[len];
        int top = -1;
        int min = Integer.MIN_VALUE;

        for (int value : preorder) {
            if (value < min) {
                return false;
            }

            while (top > -1 && value > stack[top]) {
                min = stack[top];
                top--;
            }

            stack[++top] = value;
        }

        return true;
    }

}
