import java.util.List;

public class Practical {
    public int minCostClimbingStairs(int[] cost) {//p[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])状态转移
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
        /*
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];

             */
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /*
        给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。

        另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。

        返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
         */


        return new double[]{};
    }
    public int maxProfit(int[] prices) {
        /*
        给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

        设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

        经典DP
         */
        int root[]=new int[prices.length];
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }


}
