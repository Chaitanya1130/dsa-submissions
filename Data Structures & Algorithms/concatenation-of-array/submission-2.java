class Solution {
    public int[] getConcatenation(int[] nums) {
        int [] ans=new int[nums.length*2];
        int i=0,j=0;
        while(j<=ans.length-1){
            if(i==nums.length){
                i=0;
            }
            System.out.println(nums[i]+"----- "+ans[j]);
            ans[j++]=nums[i++];
        }
        return ans;
    }
}