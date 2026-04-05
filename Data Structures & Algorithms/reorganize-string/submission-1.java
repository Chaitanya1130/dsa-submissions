class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]   // max heap by frequency
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                heap.offer(new int[]{freq[i], i});
            }
        }

        StringBuilder st = new StringBuilder();
        int[] prev = null;

        while (!heap.isEmpty()) {

            int[] curr = heap.poll();

            // 🔴 YOUR CHECK — handled correctly
            if (prev != null && curr[1] == prev[1]) {

                // no other option → impossible
                if (heap.isEmpty()) return "";

                // take second best
                int[] next = heap.poll();

                // use second best
                st.append((char) (next[1] + 'a'));
                next[0]--;

                // put curr back
                heap.offer(curr);

                // reinsert prev if needed
                if (prev[0] > 0) heap.offer(prev);

                // update prev
                prev = next;
            }
            else {
                // normal case
                st.append((char) (curr[1] + 'a'));
                curr[0]--;

                if (prev != null && prev[0] > 0) {
                    heap.offer(prev);
                }

                prev = curr;
            }
        }

        return st.length() == s.length() ? st.toString() : "";
    }
}
