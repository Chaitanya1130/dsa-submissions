class Solution {
    public String reorganizeString(String s) {
        int[]freq=new int [26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        Queue<int[]>heap=new PriorityQueue<>(
            (a,b)->b[0]-a[0]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                heap.offer(new int[]{freq[i], i});
            }
        }
        StringBuilder st=new StringBuilder();
        int[]prev=null;
        while(!heap.isEmpty()){
            int[]curr=heap.poll();
            if(prev!=null && curr[1]==prev[1]){
                if(heap.isEmpty()){
                    return "";
                }
                int[]next=heap.poll();
                st.append((char)(next[1]+'a'));
                next[0]--;
                heap.offer(curr);
                if(prev[0]>0){
                    heap.offer(prev);
                }
                prev=next;
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