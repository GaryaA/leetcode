package org.example.leetcode.arrays;

public class BestTimetoBuyandSellStockII {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimetoBuyandSellStockII().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int buy = prices[0];
        int sumMaxProfits = 0;
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < buy) {
                buy = prices[i];
                continue;
            }

            if (prices[i] - buy > 0) {
                sumMaxProfits += prices[i] - buy;
                buy = prices[i];
            }
        }
        return sumMaxProfits;
    }

}
