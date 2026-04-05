

class Solution {
    private Boolean[] memo; 

    public boolean canJump(int[] nums) {
        memo = new Boolean[nums.length];
        return solve(nums, 0);
    }

    private boolean solve(int[] nums, int idx) {
        if (idx == nums.length - 1) return true;
        if (memo[idx] != null) return memo[idx];

        for (int jump = 1; jump <= nums[idx]; jump++) {
            if (solve(nums, idx + jump)) {
                return memo[idx] = true;
            }
        }

        return memo[idx] = false;
    }
}
