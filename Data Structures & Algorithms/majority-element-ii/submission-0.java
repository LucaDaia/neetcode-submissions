class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<nums.length;i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> pair : freq.entrySet()) {
            if(pair.getValue() > nums.length / 3) {
                res.add(pair.getKey());
            }
        }

        return res;
    }
}