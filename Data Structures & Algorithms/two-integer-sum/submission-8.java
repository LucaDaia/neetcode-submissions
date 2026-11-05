class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(seen.containsKey(target - nums[i])) {
                res[0] = seen.get(target - nums[i]);
                res[1] = i;
                return res;
            } else {
                if(!seen.containsKey(nums[i])) {
                    seen.put(nums[i], i);
                }
            }
        }

        return res;
    }
}
