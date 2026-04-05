class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

    Map<Character, Integer> need = new HashMap<>();
    for (char c : s1.toCharArray()) {
        need.put(c, need.getOrDefault(c, 0) + 1);
    }

    for (int i = 0; i <= s2.length() - s1.length(); i++) {
        Map<Character, Integer> window = new HashMap<>();
        for (int j = i; j < i + s1.length(); j++) {
            char c = s2.charAt(j);
            window.put(c, window.getOrDefault(c, 0) + 1);
        }
        if (window.equals(need)) return true;  // ✅ same counts
    }

    return false;
    }
}
