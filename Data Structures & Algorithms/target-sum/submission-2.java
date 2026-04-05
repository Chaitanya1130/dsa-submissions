class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return help(0,nums,target);
    }
    private int help(int index,int []nums,int target){
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }

        int pos=help(index+1,nums,target+nums[index]);
        int neg=help(index+1,nums,target-nums[index]);
        return pos+neg;
    }
}
