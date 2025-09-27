package org.example.leetcode.arrays;

public class BestTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new BestTimetoBuyandSellStockIII().maxProfit(prices));
    }

    //Можно сделать только 2 транзакции. На каждый день можно сделать одну транзакцию до и одну после.
    //Складываем максимально возможные тр на каждый день и ищем макс.
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        if (prices.length == 2) {
            return prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        }

        int[] profits = new int[prices.length - 2];

        {
            int leftBuy = 0;
            int leftSell = -1;
            int candidateLeftBuy = -1;

            for (int i = 1; i < prices.length - 1; i++) {
                if (leftSell != -1) {
                    if (prices[i] >= prices[leftSell]) {//todo candidate leftBuy
                        leftSell = i;
                    } else if (candidateLeftBuy == -1 || prices[i] < prices[candidateLeftBuy]) {
                        candidateLeftBuy = i;
                    }
                    if (candidateLeftBuy != -1 && prices[i] - prices[candidateLeftBuy] > prices[leftSell] - prices[leftBuy]) {
                        leftSell = i;
                        leftBuy = candidateLeftBuy;
                    }
                } else {
                    if (prices[i] > prices[leftBuy]) {
                        leftSell = i;
                    } else {
                        leftBuy = i;
                    }
                }
                profits[i - 1] = (leftSell != -1 ? prices[leftSell] - prices[leftBuy] : 0);
            }
        }

        {
            int rightBuy = -1;
            int rightSell = prices.length - 1;
            int candidateRightSell = -1;
            for (int i = prices.length - 2; i > 0; i--) {
                if (rightBuy != -1) {
                    if (prices[i] <= prices[rightBuy]) {
                        rightBuy = i;
                    } else if (candidateRightSell == -1 || prices[i] > prices[candidateRightSell]) {
                        candidateRightSell = i;
                    }
                    if (candidateRightSell != -1 && prices[candidateRightSell] - prices[i] > prices[rightSell] - prices[rightBuy]) {
                        rightBuy = i;
                        rightSell = candidateRightSell;
                    }
                } else {
                    if (prices[i] > prices[rightSell]) {
                        rightSell = i;
                    } else {
                        rightBuy = i;
                    }
                }
                profits[i - 1] = profits[i - 1] + (rightBuy != -1 ? prices[rightSell] - prices[rightBuy] : 0);
            }
        }

        int maxProfit = 0;
        for (int profit : profits) {
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

}
