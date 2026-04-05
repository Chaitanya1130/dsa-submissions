class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        int count=0,longe=0;
        for(int x:set){
            if(!set.contains(x-1)){
                count=1;
                int next=x+1;
                while(set.contains(next)){
                    count+=1;
                    next+=1;
                }
                longe=Math.max(longe,count);
            }
        }
        return longe;
    }
}
