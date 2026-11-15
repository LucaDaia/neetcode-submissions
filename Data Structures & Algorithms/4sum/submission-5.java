class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            // if (nums[i] > target)
            //     break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                // if (nums[i] + nums[j] > target)
                //     break;
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int l = j + 1;
                int r = nums.length - 1;

                long newTarget = (long)target - nums[i] - nums[j];

                while (l < r) {
                    long sum = (long) nums[l] + nums[r];
                    if (sum > newTarget) {
                        r--;
                    } else if (sum < newTarget) {
                        l++;
                    } else if (sum == newTarget) {
                        res.add(Arrays.asList(new Integer[] {nums[i], nums[j], nums[l], nums[r]}));
                        l++;
                        r--;

                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }

                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    }
                }
            }
        }

        return res;
    }
}