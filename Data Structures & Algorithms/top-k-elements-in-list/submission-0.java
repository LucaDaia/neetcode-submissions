class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
            for (int n : nums)
                count.put(n, count.getOrDefault(n, 0) + 1);

            List<Integer>[] buckets = new ArrayList[nums.length + 1];

            for (int key : count.keySet()) {
                int freq = count.get(key);

                if (buckets[freq] == null)
                    buckets[freq] = new ArrayList<>();

                buckets[freq].add(key);
            }

            int[] res = new int[k];
            int index = 0;

            for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
                if (buckets[i] != null) {
                    for (int n : buckets[i]) {
                        res[index++] = n;
                        if (index == k) break;
                    }
                }
            }

            return res;
    }
}
