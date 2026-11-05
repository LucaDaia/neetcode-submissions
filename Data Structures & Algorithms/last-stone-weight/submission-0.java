class Solution {
    public int lastStoneWeight(int[] stones) {
         PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones) {
            heap.offer(stone);
        }
        while(heap.size() > 1) {
            int firstStone = heap.poll();
            int secondStone = heap.poll();
            
            
            if(firstStone > secondStone){
                heap.offer(firstStone - secondStone);
            }
        }
        
        if(heap.size() == 1) {
            return heap.poll();
        } else return 0;
    }
}
