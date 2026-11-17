class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle = left + (right - left) / 2; // for integer overflow

        while (left <= right) {
            if (nums[middle] == target)
                return middle;

            if (nums[middle] > target) {
                right = middle-1;

            } else {
                left = middle+ 1;
            }
            middle = left + (right - left) / 2;
        }

        return -1;
    }
}
