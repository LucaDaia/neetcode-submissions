class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        res = binarySearch(0, nums.length - 1, nums, target);
        return res;
    }

    public int binarySearch(int l, int r, int[] nums, int target) {
        
        int mid = l + (r - l) / 2;

        if(l>r) return -1;
        
        if (nums[mid] == target)
            return mid;

        if (nums[mid] < target) {
            return binarySearch(mid + 1, r, nums, target);

        } else {
            return binarySearch(l, mid - 1, nums, target);
        }
    }
}
