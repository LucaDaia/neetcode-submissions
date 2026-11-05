class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //temperatures = [30,38,30,36,35,40,28]

        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<temperatures.length;i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int lastIndex = stack.pop();
                res[lastIndex] = i - lastIndex;
            }
            stack.push(i);
        }
        for(int i=0;i <stack.size();i++) {
            res[stack.pop()] = 0;
        }
        return res;
    }
}
