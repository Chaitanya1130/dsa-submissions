class Solution {
    public String minWindow(String s, String t) {
         Map<Character,Integer> map1 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int count = map1.size();     
        boolean found = false;
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;

        int i = 0, j = 0;

        while (j < s.length()) {
            char r = s.charAt(j);
            if (map1.containsKey(r)) {
                map1.put(r, map1.get(r) - 1);
                if (map1.get(r) == 0) count--;     
            }

            while (count == 0) {
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    left = i;
                    right = j;
                    found = true;
                }
                char l = s.charAt(i);
                if (map1.containsKey(l)) {
                    map1.put(l, map1.get(l) + 1);
                    if (map1.get(l) > 0) count++;  
                }
                i++;
            }

            j++; 
        }

        return found ? s.substring(left, right + 1) : "";
    }
}
