package cn.jjx.coding.leetcode.classification.design;

public class LC251_展开二维向量_mid {

    //需要过滤掉空数组元素
    class Vector2D {
        int i = 0;
        int j = 0;
        int[][] v;
        public Vector2D(int[][] v) {
            this.v = v;
            skipEmpty();
        }

        public int next() {
            int result = v[i][j];
            j ++;
            if (v[i].length == j) {
                i ++;
                skipEmpty();
                j = 0;
            }
            return result;
        }

        public void skipEmpty() {
            // skip empty.
            while (i < v.length && v[i].length == 0) {
                i ++;
            }
        }

        public boolean hasNext() {
            return i < v.length && j < v[i].length;
        }
    }

}
