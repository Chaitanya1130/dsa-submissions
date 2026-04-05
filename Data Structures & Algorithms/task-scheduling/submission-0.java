class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int f : freq) {
            if (f > 0) pq.offer(f);
        }
        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;
        while (!pq.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int curr = pq.poll() - 1;
                if (curr > 0) {
                    cooldown.offer(new int[]{curr, time + n});
                }
            }
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                pq.offer(cooldown.poll()[0]);
            }
        }

        return time;

    }
}
