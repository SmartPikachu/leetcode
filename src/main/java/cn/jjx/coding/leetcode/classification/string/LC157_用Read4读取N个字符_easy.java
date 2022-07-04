package cn.jjx.coding.leetcode.classification.string;

public class LC157_用Read4读取N个字符_easy {

    class Solution extends Reader4 {

        //这道题的read方法只能调用1次，158题可以调用多次
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int i = 0,l = 1;
            while(i < n && l != 0){
                char[] buf4 = new char[4];
                l = read4(buf4);
                for(int j = 0;j < l && i < n;j++)
                    buf[i++] = buf4[j];
            }
            return i;
        }
    }

    /**
     * The read4 API is defined in the parent class Reader4.
     * int read4(char[] buf4);
     */
    class Reader4{
        int read4(char[] buf4){
            return 1;
        }
    }

}
