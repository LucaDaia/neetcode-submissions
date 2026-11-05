class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();

        backtracking(0,nums, new ArrayList<Integer>(), res);

        return res;
        
    }

    public void backtracking(int i, int[] nums,List<Integer> path, List<List<Integer>> res) {

        if(i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[i]);
        backtracking(i + 1, nums,path, res);
        path.remove(path.size() - 1);
        backtracking(i+1, nums, path, res);
    }
}
