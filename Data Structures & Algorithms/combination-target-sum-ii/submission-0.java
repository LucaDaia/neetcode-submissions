class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Arrays.sort(candidates);

        backtracking(candidates, 0, target, path, result);
        return result;
    }

    private void backtracking(int[] candidates, int i, int target, List<Integer> path, List<List<Integer>> res) {
    if (target == 0) {
        res.add(new ArrayList<>(path));
        return;
    }
    if (target < 0 || i >= candidates.length) return;

    // choose current i
    path.add(candidates[i]);
    backtracking(candidates, i + 1, target - candidates[i], path, res);
    path.remove(path.size() - 1);

    // skip current i: move i to next distinct value to avoid duplicate sets
    int next = i + 1;
    while (next < candidates.length && candidates[next] == candidates[i]) next++;
    backtracking(candidates, next, target, path, res);
}
}
