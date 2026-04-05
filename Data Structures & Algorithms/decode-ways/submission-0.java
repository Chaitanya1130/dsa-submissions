class Solution {
    public int numDecodings(String s) {
       int[]dp=new int[s.length()+1];
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=s.length();i++){
            int oned = s.charAt(i - 1) - '0';
            int twod = Integer.parseInt(s.substring(i - 2, i));
                if (oned >= 1 && oned <= 9)
                dp[i] += dp[i - 1];

            if (twod >= 10 && twod <= 26)
                dp[i] += dp[i - 2];
            
        }
        return dp[s.length()];
    }
}
