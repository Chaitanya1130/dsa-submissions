class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        return nums.length!=set.size();
    }
}