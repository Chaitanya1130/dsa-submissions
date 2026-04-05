class Solution {
    public int lengthOfLIS(int[] nums) {
        int res=help(0,-1,nums);
        return res;
    }
    private int help(int index,int prev,int[]nums){
        if(index==nums.length){
            return 0;
        }
        int nottake=help(index+1,prev,nums);
        int take=0;
        if(prev==-1||nums[index] > nums[prev]){
            take=1+help(index+1,index,nums);
        }
        return Math.max(take, nottake);
    }
}
