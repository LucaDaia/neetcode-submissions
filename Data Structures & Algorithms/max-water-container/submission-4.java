class Solution {
    public int maxArea(int[] heights) {

        int left = 0;
        int right = heights.length - 1;
        int res = Integer.MIN_VALUE;

        while(left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            res = Math.max(res, area);
            if(heights[left] < heights[right]) left++;
            else right--;
        }

        return res;
        
    }
}
