class Solution {
    public int trap(int[] height) {
        // calculate prefix max
        int[] prefixMax = new int[height.length];
        int currMaxPre = 0;
        prefixMax[0] = 0;
        for (int i = 1; i < height.length; i++) {
            prefixMax[i] = Math.max(currMaxPre, height[i - 1]);
            currMaxPre = Math.max(currMaxPre, height[i-1]);
        }

        // calculate suffix max
        int[] suffixMax = new int[height.length];
        int currMaxSuf = 0;
        suffixMax[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(currMaxSuf, height[i + 1]);
            currMaxSuf = Math.max(currMaxSuf, height[i+1]);
        }

        // calculate amount of water per position i

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (Math.min(prefixMax[i], suffixMax[i]) - height[i] > 0) {
                res += Math.min(prefixMax[i], suffixMax[i]) - height[i];
            }
        }

        return res;
    }
}
