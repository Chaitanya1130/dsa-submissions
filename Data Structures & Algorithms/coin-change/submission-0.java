class Solution {
    public int coinChange(int[] coins, int amount) {
        int res=help(0,amount,coins);
        return res >= 1000000000 ? -1 : res;
    }
    private int help(int index,int amount,int[]coins){
        if(amount==0){
            return 0;
        }
        if(index==coins.length){
            return 1000000000;
        }
        int take=1000000000;
        if(coins[index]<=amount){
            take=1+help(index,amount-coins[index],coins);
        }
         int notTake = help(index+1,amount,coins);
        return Math.min(take,notTake);
        
    }
}
