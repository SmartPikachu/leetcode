package cn.jjx.coding.leetcode.classification.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC249_移位字符串分组_mid {

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result=new LinkedList<>();//结果数组
        LinkedList<String>temp;//临时字串数组
        HashMap<String, Integer> map=new HashMap<>();//保存有某一类型的字串在result中的索引号
        int index = 0;//妙！作为索引标记！

        for (String key : strings) {
            char[]chars= key.toCharArray();
            if (chars[0] != 'a') {
                for (int i = 1; i < chars.length; i++){//将字串进行移位操作，与开头为a的字符串对齐！
                    //计算新的字符（这里 + 26很妙！是循环数组的技巧！确保类似ba→az时，可以正常循环转换！）
                    chars[i] = (char) ((chars[i]- chars[0] + 26) % 26 + 'a');
                }
                chars[0] = 'a';//把第一个字符赋值为‘a’,字符串以a开头，完成对齐！注意！这条语句必须放在for循环之后！不能之前！
            }

            String tempKey=String.valueOf(chars);//转化完成后的字符串

            if (map.containsKey(tempKey)){//如果已经存在，则直接添加到result即可
                result.get(map.get(tempKey)).add(key);
            }else {//如果不存在，则需要添加到map中去，然后再添加到result
                map.put(tempKey,index);
                index++;
                temp=new LinkedList<>();
                temp.add(key);
                result.add(temp);
            }
        }
        return result;
    }

}
