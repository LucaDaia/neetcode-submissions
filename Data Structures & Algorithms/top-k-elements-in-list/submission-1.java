class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[]{entry.getValue(), entry.getKey()});

            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[] res = new int[k];
        int j = queue.size();
        for(int i=0;i<j;i++) {
            res[i] = queue.poll()[1];
        }

        return res;
    }
}
