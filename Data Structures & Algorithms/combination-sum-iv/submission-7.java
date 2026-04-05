
class Solution {
    public int combinationSum4(int[] nums, int target) {
        // Initialize dp array of primitive ints with -1 to indicate 'not calculated'
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        
        // The base case for the main function is technically covered by the recursive helper
        // but we ensure the calculation starts
        return help(nums, target, dp);
    }
    
    private int help(int[] nums, int target, int[] dp) {
        // Base Case 1: Target reached
        if (target == 0) return 1;
        
        // Base Case 2: Target exceeded
        if (target < 0) return 0;
        
        // Memoization Check: If the state is NOT -1, it has been calculated
        if (dp[target] != -1) return dp[target]; // Corrected line: Check against -1

        int count = 0;
        for (int num : nums) {
            count += help(nums, target - num, dp);
        }

        // Store and return the result
        return dp[target] = count;
    }
}