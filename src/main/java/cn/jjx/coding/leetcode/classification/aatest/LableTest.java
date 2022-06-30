package cn.jjx.coding.leetcode.classification.aatest;

import org.junit.Test;

public class LableTest {

    @Test
    public void fun2() {
        int i = 0;
        label:
        for (int j = 0; j < 2; j++) {
            for (i = 1; i < 3; i++) {
                System.out.println(i);
//                if (i == 5) {
//                    //这样就可以跳出整个大循环了,break label 也会中断所有循环，并回到 label1 处，但并不重
//                    //新进入循环。也就是说，它实际是完全中止了两个循环。
//                    break label;
//                }
                if(i==2){
                    continue label;
                }
            }
        }
    }

    public static void main(String[] args) {
        byte[] bytes = new byte[258];
        bytes[0]='1';
        bytes[1]='2';
        System.out.println(bytes.length);
    }
}
