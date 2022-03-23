package cn.jjx.coding.leetcode.classification.design;

import java.util.Deque;
import java.util.LinkedList;

public class LC155_最小栈 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public LC155_最小栈() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
