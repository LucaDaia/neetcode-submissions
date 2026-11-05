class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        boolean[] flag = new boolean[nums.length];
        backtracking(res,new ArrayList<Integer>(),flag, nums);

        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path,boolean[] flag, int[] nums) {

        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i<nums.length; i++) {
            if(flag[i] == false) {
                path.add(nums[i]);
                flag[i] = true;
                backtracking(res, path, flag,nums);
                flag[i] = false;
                path.remove(path.size() - 1);
            }
            
        }
    }
}
