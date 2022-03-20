package cn.jjx.coding.leetcode.labuladong.design;

import cn.jjx.coding.leetcode.data_structure.NestedInteger;

import java.util.*;

public class LC341_扁平化嵌套列表迭代器 implements Iterator<Integer> {

    //储存列表当前遍历的位置
    private Deque<Iterator<NestedInteger>> stack;

    public LC341_扁平化嵌套列表迭代器(List<NestedInteger> nestedList) {
        stack=new LinkedList<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        //由于保证调用next之前会调用hasNext,直接返回栈顶列表的当前元素
        return stack.peek().next().getInteger();

    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            Iterator<NestedInteger> it = stack.peek();
            if(!it.hasNext()){
                stack.pop();
                continue;
            }
            NestedInteger nest = it.next();
            if(nest.isInteger()){
                List<NestedInteger> list = new ArrayList<NestedInteger>();
                list.add(nest);
                stack.push(list.iterator());
                return true;
            }
            stack.push(nest.getList().iterator());
        }
        return false;

    }
}
