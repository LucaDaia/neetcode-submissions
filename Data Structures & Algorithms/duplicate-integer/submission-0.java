class Solution {
    public boolean hasDuplicate(int[] nums) {
             HashSet<Integer> uniques = new HashSet<>();

        for(int i=0; i<nums.length;i++) {
            if(!uniques.contains(nums[i])) {
                uniques.add(nums[i]);
            } else {
                return true;
            }
        }

        return false;
    }
}