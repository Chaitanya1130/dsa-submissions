class Solution {
    int solve(char[]arr,int idx){
        int n=arr.length;
        if (idx == n) {
            return 1;
        }
        if(arr[idx]=='0'){
            return 0;
        }
        int ways=0;
        ways += solve(arr, idx + 1);
         if (idx + 1 < n) {
            int num = (arr[idx] - '0') * 10 + (arr[idx + 1] - '0');
            if (num >= 10 && num <= 26) { 
                ways += solve(arr, idx + 2);
            }
        }

        return ways;
    }
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        return solve(arr, 0);
    }
}
