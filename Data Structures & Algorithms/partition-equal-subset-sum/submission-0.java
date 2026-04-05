class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0)return false;
        int target=sum/2;
        return help(0,target,nums);
    }
    private boolean help(int index,int target,int[]nums){
        if(index==nums.length || target<0){
            return false;
        }
        if(target==0){
            return true;
        }
        boolean take=help(index+1,target-nums[index],nums);
        boolean nottake=help(index+1,target,nums);
        return take||nottake;
    }
}
