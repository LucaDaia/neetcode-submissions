
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visiting = new HashSet<>(); // recursion stack

        // Initialize ALL courses
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        // Build graph
        for (int[] pair : prerequisites) {
            map.get(pair[0]).add(pair[1]);
        }

        // DFS every course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visiting)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course,
                        HashMap<Integer, List<Integer>> map,
                        Set<Integer> visiting) {

        // already verified → no cycle from here
        if (map.get(course).isEmpty()) {
            return true;
        }

        // cycle detected
        if (visiting.contains(course)) {
            return false;
        }

        visiting.add(course);

        for (int prereq : map.get(course)) {
            if (!dfs(prereq, map, visiting)) {
                return false;
            }
        }

        visiting.remove(course);

        // memoize: mark course as processed
        map.put(course, new ArrayList<>());
        return true;
    }
}
