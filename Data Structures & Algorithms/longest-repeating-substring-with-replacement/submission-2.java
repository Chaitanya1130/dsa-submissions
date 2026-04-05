class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int maxf = 0;
        int maxl = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {
            char rc = s.charAt(r);
            map.put(rc, map.getOrDefault(rc, 0) + 1); 
            maxf = Math.max(maxf, map.get(rc));

            int rep = (r - l + 1) - maxf;
            if (rep > k) {
                char lc = s.charAt(l);
                map.put(lc, map.get(lc) - 1);
                l++;
            }

            maxl = Math.max(maxl, (r - l + 1));
            r++; 
        }

        return maxl;
    }
}
