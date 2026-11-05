class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subList  = new ArrayList<>();

        dfs(nums,res, subList, target, 0);

        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, List<Integer> subList, int target, int i) {

        if(target == 0) {
            res.add(new ArrayList<>(subList));
            return;
        }
        if(target < 0 || i>=nums.length) {
            return;
        }

        target -= nums[i];
        subList.add(nums[i]);
        dfs(nums, res, subList, target,i);
        subList.remove(subList.size() - 1);
        dfs(nums, res, subList,target + nums[i], i+1);

    }
}

