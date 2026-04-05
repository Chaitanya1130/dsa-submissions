class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0;
        int sum=0;
        int min = Integer.MAX_VALUE;
        while(r<nums.length){
           sum += nums[r]; // add current element
            r++;
            while(sum>=target){
                int len = r - l;
                min = Math.min(len, min); // update answer
                sum -= nums[l]; // remove left element
                l++;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
}