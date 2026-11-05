class Solution {
     public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If complement exists, we've found the pair
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise store current number's index
            map.put(nums[i], i);
        }

        // Problem guarantees a solution, but return empty array if not found
        return new int[] {};
    }
}
