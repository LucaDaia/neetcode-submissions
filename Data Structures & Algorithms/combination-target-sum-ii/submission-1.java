class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(0, target, candidates, new ArrayList<>());
        return res;
    }

    public void backtracking(int i, int target, int[] candidates, List<Integer> path) {

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0 || i >= candidates.length) {
            return;
        }

        // ---- TAKE ----
        path.add(candidates[i]);
        backtracking(i + 1, target - candidates[i], candidates, path);
        path.remove(path.size() - 1);

        // ---- SKIP duplicates ----
        int temp = candidates[i];
        int next = i;
        while (next < candidates.length && candidates[next] == temp) {
            next++;
        }

        // ---- SKIP ----
        backtracking(next, target, candidates, path);
    }
}
