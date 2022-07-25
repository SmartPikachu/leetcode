package cn.jjx.coding.leetcode.classification.divide_and_conquer;

public class LC395_至少有K个重复字符的最长子串_mid {

    /**
     * 分治法
     * 对于字符串s，如果存在某个字符ch，它的出现次数大于0且小于k，
     * 则任何包含ch的子串都不可能满足要求。也就是说，
     * 我们将字符串按照ch切分成若干段，则满足要求的最长子串一定出现在某个被切分的段内，
     * 而不能跨越一个或多个段。因此，可以考虑分治的方式求解本题。
     *
     */
    class Solution {
        public int longestSubstring(String s, int k) {
            int n = s.length();
            return dfs(s, 0, n - 1, k);
        }

        public int dfs(String s, int l, int r, int k) {
            int[] cnt = new int[26];
            for (int i = l; i <= r; i++) {
                cnt[s.charAt(i) - 'a']++;
            }

            char split = 0;
            //先找出分割字符
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0 && cnt[i] < k) {
                    split = (char) (i + 'a');
                    break;
                }
            }
            //如果是0那么说明都大于等于k，直接放回。
            if (split == 0) {
                return r - l + 1;
            }

            int i = l;
            int ret = 0;
            //从左到右开始遍历
            while (i <= r) {
                while (i <= r && s.charAt(i) == split) {
                    i++;
                }
                if (i > r) {
                    break;
                }
                //记录不等于分隔符的起始位置。
                int start = i;
                while (i <= r && s.charAt(i) != split) {
                    i++;
                }
                //对符合条件的start,i-1这段递归求长度
                int length = dfs(s, start, i - 1, k);
                ret = Math.max(ret, length);
            }
            return ret;
        }
    }

}
