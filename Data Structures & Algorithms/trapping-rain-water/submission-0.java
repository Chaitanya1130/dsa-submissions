class Solution {
    public int trap(int[] height) {
        int i=0,j=height.length-1;
        int leftmax=height[i];
        int rightmax=height[j];
        int res=0;
        while(i<j){
            if(leftmax<rightmax){
                i++;
                leftmax=Math.max(leftmax,height[i]);
                res+=leftmax-height[i];
            }
            else{
                j--;
                rightmax=Math.max(rightmax,height[j]);
                res+=rightmax-height[j];
            }
        }
        return res;
    }
}
