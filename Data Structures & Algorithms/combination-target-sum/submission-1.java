class Solution {
   public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    backtracking(0, target, new ArrayList<>(), res, nums);
    return res;
}

private void backtracking(int i, int target, List<Integer> subArray,
                          List<List<Integer>> res, int[] nums) {

    if (target == 0) {
        res.add(new ArrayList<>(subArray));
        return;
    }

    if (i >= nums.length || target < 0) return;

    // Choose nums[i]
    subArray.add(nums[i]);
    backtracking(i, target - nums[i], subArray, res, nums);
    subArray.remove(subArray.size() - 1);

    // Skip nums[i] and move forward
    backtracking(i + 1, target, subArray, res, nums);
}

}

