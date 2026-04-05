class Solution {
    public int[] getOrder(int[][] tasks) {

        // total number of tasks
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];

        // Copy data into new structure
        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0]; // when task arrives
            sortedTasks[i][1] = tasks[i][1]; // how long it takes
            sortedTasks[i][2] = i;           // task identity
        }

        /*
         Sort tasks by enqueueTime.
         This helps us know WHICH task becomes available NEXT.
        */
        Arrays.sort(sortedTasks, (a, b) -> a[0] - b[0]);

        // This will store the final order of execution
        int[] answer = new int[n];

        /*
         currentTime simulates the CPU clock.
         Think of it as: "what time is it right now?"
        */
        long currentTime = 0;

        /*
         idx points to the next task in sortedTasks
         that has NOT been added to the heap yet.
        */
        int idx = 0;

        /*
         ansIdx tells us where to put the next task index
         in the answer array.
        */
        int ansIdx = 0;

   
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        );

        
        while (idx < n || !heap.isEmpty()) {
            if (heap.isEmpty() && currentTime < sortedTasks[idx][0]) {
                currentTime = sortedTasks[idx][0];
            }
            while (idx < n && sortedTasks[idx][0] <= currentTime) {
                heap.offer(new int[]{
                    sortedTasks[idx][1], // processing time
                    sortedTasks[idx][2]  // original index
                });
                idx++;
            }
            int[] task = heap.poll();
            currentTime += task[0];

            answer[ansIdx++] = task[1];
        }

        // Final execution order
        return answer;
    }
}
