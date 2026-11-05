class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());

        for(int i=0;i<stones.length;i++) {
            maxHeap.offer(stones[i]);
        }

        int first;
        int second;
        while(maxHeap.size() > 2) {
            first = maxHeap.poll();
            second = maxHeap.poll();

            if(first - second != 0) {
                maxHeap.offer(Math.abs(first - second));
            }
        }

        if(maxHeap.size() == 1) return maxHeap.poll();
        first = maxHeap.poll();
        second = maxHeap.poll();
        return first - second == 0 ? 0 : Math.abs(first - second);
    }
}
