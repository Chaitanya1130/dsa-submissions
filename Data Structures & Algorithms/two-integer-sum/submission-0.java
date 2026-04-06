class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> rem=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (rem.containsKey(diff)) {
                return new int[] { rem.get(diff), i };
            }

            rem.put(num, i);
        }
        return new int[] {};
    }
}
