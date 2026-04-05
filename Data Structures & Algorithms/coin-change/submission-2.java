class Solution {

    int[][] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];

        // -1 means not computed
        for(int i = 0; i < coins.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int res = help(0, amount, coins);
        return res >= 1000000 ? -1 : res;
    }

    int help(int idx, int amt, int[] coins){

        if(amt == 0) return 0;
        if(idx == coins.length) return 1000000;

        if(dp[idx][amt] != -1) return dp[idx][amt];

        int take = 1000000;

        if(coins[idx] <= amt){
            take = 1 + help(idx, amt - coins[idx], coins);
        }

        int nottake = help(idx + 1, amt, coins);

        return dp[idx][amt] = Math.min(take, nottake);
    }
}
