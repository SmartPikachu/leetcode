package cn.jjx.coding.leetcode.classification.design;

import java.util.Iterator;

public class LC284_顶端迭代器_mid {

    //这道题设置一个nextElement这处很巧妙。
    class PeekingIterator implements Iterator<Integer> {

        private Iterator<Integer> iterator;
        private Integer nextElement;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
            nextElement = iterator.next();
        }

        public Integer peek() {
            return nextElement;
        }

        @Override
        public Integer next() {
            Integer ret = nextElement;
            nextElement = iterator.hasNext() ? iterator.next() : null;
            return ret;
        }

        @Override
        public boolean hasNext() {
            return nextElement != null;
        }
    }

}
