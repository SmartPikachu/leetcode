package cn.jjx.coding.leetcode.classification.dynamic_programming.买卖股票;

public class LC121_买卖股票的最佳时机_easy {

    //一次遍历，寻找最大利润。
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

}
