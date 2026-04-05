class Solution {
    public int climbStairs(int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        int one=climbStairs(n-1);
        int two=climbStairs(n-2);
        return one+two;
    }
}
