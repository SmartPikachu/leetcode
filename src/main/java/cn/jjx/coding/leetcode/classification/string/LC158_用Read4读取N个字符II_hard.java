package cn.jjx.coding.leetcode.classification.string;

public class LC158_用Read4读取N个字符II_hard {

    class Solution extends Reader4 {
        //这道题的read方法可以调用多次，157只能调用一次
        int size = 0;
        int i = 0;
        char[] temp = new char[4];
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int index = 0;

            while(index < n){
                if(size == 0){
                    size = read4(temp);
                    if(size == 0)
                        break;
                }

                while(index < n && i < size){
                    buf[index++] = temp[i++];
                }

                if(i == size){
                    // 说明临时字符数组中的内容已经读完，
                    // size置零以便执行下一次read4操作，
                    //这块才是最关键的，没读完的不能置零
                    i = 0;
                    size = 0;
                }
            }
            return index;
        }
    }

    class Reader4{
        int read4(char[] buf4){
            return 1;
        }
    }

}
