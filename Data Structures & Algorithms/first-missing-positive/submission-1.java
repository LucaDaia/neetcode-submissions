class Solution {
    public int firstMissingPositive(int[] nums) {
        // multimea solutiilor [1 ... nums.length + 1]

        // 1st step make all negative numbers 0 so we can turn the other negative
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                nums[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) <= nums.length && Math.abs(nums[i]) >= 1) {
                if (nums[Math.abs(nums[i]) - 1] == 0) {
                    nums[Math.abs(nums[i]) - 1] = (nums.length + 1) * (-1);
                } else {
                    nums[Math.abs(nums[i]) - 1] = Math.abs(nums[Math.abs(nums[i]) - 1]) * (-1);
                }
            }
        }

        for (int possible = 1; possible < nums.length + 1; possible++) {
            if (nums[possible - 1] >= 0) {
                return possible;
            }
        }

        return nums.length + 1;
    }
}