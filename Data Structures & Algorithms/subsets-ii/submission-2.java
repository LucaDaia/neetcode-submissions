class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        backtracking(0, new ArrayList<Integer>(), nums, res);

        return res;
    }

    public void backtracking(int i, List<Integer> path, int[] nums, List<List<Integer>> res) {

        if(i >= nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[i]);
        backtracking(i+1, path, nums, res);
        path.remove(path.size() - 1);

        int next = i;
        while(next< nums.length - 1 && nums[next] == nums[next + 1]) {
            next++;
        }
        backtracking(next+1, path,nums,res);

    }
}
