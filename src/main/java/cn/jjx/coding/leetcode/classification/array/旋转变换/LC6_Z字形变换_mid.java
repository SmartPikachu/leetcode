package cn.jjx.coding.leetcode.classification.array.旋转变换;

import java.util.ArrayList;
import java.util.List;

public class LC6_Z字形变换_mid {
    public String convert(String s, int numRows) {
        if(numRows<2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i=0;i<numRows;i++) rows.add(new StringBuilder());
        int i=0,flag=-1;
        for(char c:s.toCharArray()){
            rows.get(i).append(c);
            if(i==0 || i==numRows-1) flag=-flag;
            i+=flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row:rows) res.append(row);
        return res.toString();
    }
}
