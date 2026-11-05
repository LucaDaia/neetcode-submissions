class Solution {
   public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used = new boolean[nums.length];  // easier than List<Boolean>
    
    backtrackingP(path, nums, used, res);
    return res;
}

private static void backtrackingP(List<Integer> path, int[] nums, boolean[] used, List<List<Integer>> res) {
    if (path.size() == nums.length) {
        res.add(new ArrayList<>(path));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue; // skip already used elements

        // choose
        path.add(nums[i]);
        used[i] = true;

        // explore
        backtrackingP(path, nums, used, res);

        // backtrack
        path.remove(path.size() - 1);
        used[i] = false;
    }
}

}
