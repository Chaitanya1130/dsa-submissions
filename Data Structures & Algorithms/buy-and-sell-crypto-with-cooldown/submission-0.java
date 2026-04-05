class Solution {
    public int maxProfit(int[] prices) {
        return help(0,1,prices);
    }
    private int help(int index,int check,int[]arr){
        if (index >= arr.length) return 0;
        if(check==1){
            int take=-arr[index]+help(index+1,0,arr);
            int nottake=help(index+1,1,arr);
            return Math.max(take,nottake);
        }
        else{
            int sell=arr[index]+help(index+2,1,arr);
            int dontsell=help(index+1,0,arr);
            return Math.max(sell,dontsell);
        }

    }
}
