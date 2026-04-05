class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0)return false;
        int target=sum/2;
        Boolean [][]dp=new Boolean[nums.length][target+1];
        return help(0,target,nums,dp);
    }
    private boolean help(int index,int target,int[]nums,Boolean[][]dp){
        if(index==nums.length || target<0){
            return false;
        }
        if(target==0){
            return true;
        }
        if(dp[index][target]!=null){
            return dp[index][target];
        }
        boolean take = help(index + 1, target - nums[index], nums, dp);
        boolean nottake = help(index + 1, target, nums, dp);
        return dp[index][target]=take||nottake;
    }
}
