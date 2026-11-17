class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length - 1;
        int m = l + (r-l)/2;

        while(l <= r) {

            if(nums[m] == target) return m;

            if(nums[m] < target) l = m+1;
            else r = m - 1;

            m = l + (r-l)/2;
        }

        return r + 1;
    }
}