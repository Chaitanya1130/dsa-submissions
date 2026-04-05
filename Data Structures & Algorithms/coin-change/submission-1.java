class Solution {
    public int coinChange(int[] coins, int amount) {
        int res=help(0,amount,coins);
        return res >= 1000000 ? -1 : res;
    }
    int help(int idx,int amt,int[]coins){
        if(amt==0){
            return 0;
        }
        if(idx==coins.length){
            return 1000000;
        }
        int take=1000000;
        if(coins[idx]<=amt){
            take=1+help(idx,amt-coins[idx],coins);
        }
        int nottake=help(idx+1,amt,coins);
        return Math.min(take,nottake);
    }
}
