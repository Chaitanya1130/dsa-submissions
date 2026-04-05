class Solution {
    public int[] asteroidCollision(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {

            int curr = nums[i];
            if (stack.isEmpty()) {
                stack.push(curr);
                continue;
            }
            if ((stack.peek() < 0 && curr < 0) || (stack.peek() > 0 && curr > 0) || curr > 0) {
                stack.push(curr);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > 0 && curr < 0) {

                if (Math.abs(stack.peek()) < Math.abs(curr)) {
                    stack.pop();      
                    continue;
                }
                else if (Math.abs(stack.peek()) == Math.abs(curr)) {
                    stack.pop();      
                    curr = 0;         
                    break;
                }
                else {
                    curr = 0;         
                    break;
                }
            }

            if (curr != 0) {
                stack.push(curr);
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
