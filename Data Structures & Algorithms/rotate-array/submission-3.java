class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k%n - 1);
        reverse(nums, k%n, nums.length - 1);

    }

    public void reverse(int[] nums, int l, int r) {
        
        int temp;
        while(l <= r) {
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}