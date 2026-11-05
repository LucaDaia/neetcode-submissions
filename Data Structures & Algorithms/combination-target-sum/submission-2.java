class Solution {
    List<List<Integer>> res = new ArrayList<>();

   public List<List<Integer>> combinationSum(int[] nums, int target) {

    List<Integer> path = new ArrayList<>();
    backtracking(nums, target, 0, path);

    return res;
   }

   public void backtracking(int[] nums, int target, int i, List<Integer> path) {

        if(target==0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if(target < 0 || i >= nums.length) {
            return;
        }

        path.add(nums[i]);
        backtracking(nums, target - nums[i], i, path);
        path.remove(path.size() - 1);
        backtracking(nums, target, i+1, path);
   }
}

