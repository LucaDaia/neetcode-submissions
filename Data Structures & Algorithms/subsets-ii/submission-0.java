class Solution {

    Set<List<Integer>> res = new HashSet<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        backtrack(0, nums);
        List<List<Integer>> resList = new ArrayList<>(res);

        
        return resList;
    }

    public void backtrack(int i, int[] nums) {

        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        if(i>=nums.length) {
            return;
        }

        path.add(nums[i]);
        res.add(new ArrayList<>(path));
        backtrack(i+1, nums);
        path.remove(path.size() - 1);
        while(i + 1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        backtrack(i+1, nums);

    }
}
