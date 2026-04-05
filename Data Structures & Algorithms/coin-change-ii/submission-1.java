class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return help(0, amount, coins,dp);
    }
    private int help(int index, int amt, int[] coins,int[][]dp) {
        
        if (amt == 0) {
            return 1;
        }        
        if (index == coins.length || amt < 0) {
            return 0;
        }      
        if (dp[index][amt] != -1) {
            return dp[index][amt];
        }  
        int take = help(index, amt - coins[index], coins,dp);
        int notTake = help(index + 1, amt, coins,dp);

        return dp[index][amt]=take + notTake;
    }
}