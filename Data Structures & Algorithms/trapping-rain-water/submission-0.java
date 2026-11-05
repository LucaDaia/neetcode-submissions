class Solution {
    public int trap(int[] height) {
        
        int[] leftMaxes = new int[height.length];
        int[] rightMaxes = new int[height.length];

       int maxLeft = 0;
       for(int i=0;i<height.length;i++) {
            leftMaxes[i] = maxLeft;
            maxLeft = Math.max(maxLeft, height[i]);
       }

       int maxRight = 0;
       for(int i=height.length - 1; i>=0;i--) {
            rightMaxes[i] = maxRight;
            maxRight = Math.max(maxRight, height[i]);
       }

        int res = 0;
        for(int i=0;i<height.length;i++) {
            int cellValue = Math.min(leftMaxes[i], rightMaxes[i]) - height[i];
            if(cellValue>0) res+=cellValue;
        }

        return res;

    }
}
