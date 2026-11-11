
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        Integer[][] pairs = new Integer[freq.size()][2];

        int j = 0;
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pairs[j][0] = entry.getKey();
            pairs[j][1] = entry.getValue();
            j++;
        }

        PriorityQueue<Integer[]> heap =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for(int i = 0; i < freq.size(); i++) {
            heap.offer(pairs[i]);

            if(heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;

        while(!heap.isEmpty()) {
            res[i++] = heap.poll()[0];
        }

        return res;
    }
}
