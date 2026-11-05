class Solution {
    public int majorityElement(int[] nums) {
        int k = 1;
        int curr = nums[0];

        for(int i = 1; i<nums.length; i++) {
            if(k == 0) curr = nums[i];
            if(nums[i] == curr) k++;
            else k--;
        }

        return curr;
    }
}