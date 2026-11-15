class Solution {
    public int maxArea(int[] heights) {
        
        int left = 0;
        int right = heights.length - 1;

        int max = 0;

        while(left <= right) {
            max = Math.max(max, calculateArea(heights, left, right));

            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public int calculateArea(int[] nums, int l, int r) {
        return Math.min(nums[l], nums[r]) * (r-l);
    }
}
