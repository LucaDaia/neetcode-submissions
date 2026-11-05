class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();

        backtracking(0, target, nums, new ArrayList<Integer>(), res);

        return res;
        
    }

    public void backtracking(int i, int target, int[] nums, List<Integer> path, List<List<Integer>> res) {

        if(target < 0 || i >= nums.length) return;

        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[i]);
        backtracking(i, target - nums[i], nums, path, res);
        path.remove(path.size() - 1);
        backtracking(i+1, target, nums,path,res);

    }
}
