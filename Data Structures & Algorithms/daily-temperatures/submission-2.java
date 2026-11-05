class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer, Integer>> tempStack = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++) {
            while(!tempStack.isEmpty() && temperatures[i] > tempStack.peek().getValue()) {
                Pair<Integer, Integer> poppedPair = tempStack.pop();
                res[poppedPair.getKey()] = i - poppedPair.getKey();
            }
            tempStack.push(new Pair(i, temperatures[i]));
        }

        return res;
    }
}
