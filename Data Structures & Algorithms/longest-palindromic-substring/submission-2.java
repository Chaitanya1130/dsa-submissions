class Solution {
  boolean palcheck(String s, int i, int j) {
    while (i < j) {
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}

    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (palcheck(s, i, j)) {
                    String sub = s.substring(i, j + 1);
                    if (sub.length() > ans.length()) {
                        ans = sub; 
                    }
                }
            }
        }

        return ans;
    }
}
