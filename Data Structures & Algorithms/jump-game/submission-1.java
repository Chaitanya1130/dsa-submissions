class Solution {
    public boolean canJump(int[] nums) {
        return solve(nums,0);
    }
    private boolean solve(int[]nums,int idx){
        if(idx==nums.length-1){
            return true;
        }
        if(idx>=nums.length){
            return false;
        }
        for(int i=1;i<=nums[idx];i++){
            if(solve(nums,i+idx)){
                return true;
            }
        }
        return false;
    }
}
