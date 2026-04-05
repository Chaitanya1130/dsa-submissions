class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         int n = nums.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ans[idx++] = max;
        }
        return ans;
    }
}
