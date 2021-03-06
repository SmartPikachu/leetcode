package cn.jjx.coding.leetcode.classification.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC271_字符串的编码与解码_mid {

    //解法一，使用非 ASCII 码的分隔符。
    public class Codec {
        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            if (strs.size() == 0) return Character.toString((char)258);

            String d = Character.toString((char)257);
            StringBuilder sb = new StringBuilder();
            for(String s: strs) {
                sb.append(s);
                sb.append(d);
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            String d = Character.toString((char)258);
            if (s.equals(d)) return new ArrayList();

            d = Character.toString((char)257);
            return Arrays.asList(s.split(d, -1));
        }
    }


    //解法二，使用数据流被分成块，每个块前面都有其字节大小。
    public class Codec1 {
        // Encodes string length to bytes string
        public String intToString(String s) {
            int x = s.length();
            char[] bytes = new char[4];
            for(int i = 3; i > -1; --i) {
                //这里的0xff代表255，11111111，估计它是考虑32位，
                //分别把31-24,23-16,15-8,7-0，这四个8位分别保存在bytes[3]-bytes[0]中
                bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
            }
            return new String(bytes);
        }

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for(String s: strs) {
                sb.append(intToString(s));
                sb.append(s);
            }
            return sb.toString();
        }

        // Decodes bytes string to integer
        public int stringToInt(String bytesStr) {
            int result = 0;
            for(char b : bytesStr.toCharArray())
                result = (result << 8) + (int)b;
            return result;
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            int i = 0, n = s.length();
            List<String> output = new ArrayList<>();
            while (i < n) {
                int length = stringToInt(s.substring(i, i + 4));
                i += 4;
                output.add(s.substring(i, i + length));
                i += length;
            }
            return output;
        }
    }

}
