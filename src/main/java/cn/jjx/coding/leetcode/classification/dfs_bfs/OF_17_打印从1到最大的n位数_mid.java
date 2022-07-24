package cn.jjx.coding.leetcode.classification.dfs_bfs;

public class OF_17_打印从1到最大的n位数_mid {

    /**
     * 全排列解法,在数字很大的情况下，哪怕long类型也无法承载，那必须要用字符串保存。
     * 对于本题其实就是对数字0~9的全排列，从1位数0~9的全排列到n位数0~9的全排列，
     * 其中要注意的是数字开头不应该有0。
     *为了能够测试通过，最后把字符串形式变成了int形式，其实应该返回字符串数组
     *
     * 以下是具体步骤
     * 为了避免数字开头出现0，先把首位first固定，first取值范围为1~9
     * 用digit表示要生成的数字的位数，本题要从1位数一直生成到n位数，
     * 对每种数字的位数都生成一下首位，所以有个双重for循环
     * 生成首位之后进入递归生成剩下的digit - 1位数，从0~9中取值
     * 递归的中止条件为已经生成了digit位的数字，即index == digit，
     * 将此时的数num转为int加到结果res中
     *
     */

    int[] res;
    int count = 0;

    public int[] printNumbers(int n) {
        //n位数最大的数是10^n-1
        res = new int[(int)Math.pow(10, n) - 1];
        //分别从1位开始计算，计算到n位
        for(int digit = 1; digit < n + 1; digit++){
            //首位是1-9，然后从index=1开始递归。
            for(char first = '1'; first <= '9'; first++){
                char[] num = new char[digit];
                num[0] = first;
                dfs(1, num, digit);
            }
        }
        return res;
    }

    private void dfs(int index, char[] num, int digit){
        if(index == digit){
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        for(char i = '0'; i <= '9'; i++){
            num[index] = i;
            dfs(index + 1, num, digit);
        }
    }


}
