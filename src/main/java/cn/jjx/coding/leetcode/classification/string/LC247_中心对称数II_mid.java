package cn.jjx.coding.leetcode.classification.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC247_中心对称数II_mid {

    public List<String> findStrobogrammatic(int n) {
        return helper(n,n);
    }
    // n表示，当前循环中，求得字符串长度； m表示题目中要求的字符串长度
    public List<String> helper(int n, int m){
        // 第一步：判断输入或者状态是否合法
        if(n<0 || m<0 || n>m){
            return new ArrayList<>();
        }
        // 第二步：判断递归是否应当结束
        if (n==0)
            return new ArrayList<>(Collections.singletonList(""));
        if (n==1)
            return new ArrayList<>(Arrays.asList("0","1","8"));

        // 第三步：缩小问题规模
        List<String> list = helper(n-2, m);

        // 第四步：整合结果
        List<String> res = new ArrayList<>();
        for (String s : list){
            if (n!=m)
                // n=m时，表示最外层处理。
                // 例如：原始需求n=m=2, '00'不合法
                // 若原始需求n=m=4, 内层循环n=2,m=4,'00';最外层循环，n=m=4时，'1001'
                res.add("0"+s+"0");
            res.add("1"+s+"1");
            res.add("6"+s+"9");
            res.add("8"+s+"8");
            res.add("9"+s+"6");
        }
        return res;
    }

}
