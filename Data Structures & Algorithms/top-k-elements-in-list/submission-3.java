class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] bsArray = new ArrayList[nums.length+1];
        for (int i = 0; i < nums.length+1; i++) {
            bsArray[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            bsArray[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int curr = 0;
        for (int i = nums.length; i >= 0; i--) {
            for (int num : bsArray[i]) {
                if (curr < k) {
                    res[curr] = num;
                    curr++;
                } else
                    break;
            }
        }

        return res;
    }
}
