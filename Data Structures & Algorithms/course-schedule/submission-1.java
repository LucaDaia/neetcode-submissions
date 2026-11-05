class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<numCourses;i++) {
            adjList.put(i, new ArrayList<Integer>());
        }

        for(int[] pair : prerequisites) {
            adjList.get(pair[0]).add(pair[1]);
        }

        for(int i=0;i<numCourses;i++) {
            if(!cycleDetection(adjList, visited, i)) {
                return false;
            }
        }

        return true;
    }

    public boolean cycleDetection(Map<Integer,List<Integer>> adjList, Set<Integer> visited, int course) {

        if(visited.contains(course)) {
            return false;
        }

        if(adjList.get(course) == null) {
            return true;
        }

        visited.add(course);

        for(int i=0;i<adjList.get(course).size();i++) {
            if(!cycleDetection(adjList, visited, adjList.get(course).get(i))) {
                return false;
            }
        }

        adjList.put(course, new ArrayList<Integer>());
        visited.remove(course);

        return true;
    }
}
