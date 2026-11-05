class Solution {
    public static boolean validTree(int n, int[][] edges) {

        if(edges.length == 0) {
            return true;
        }
        
        List<List<Integer>> adjLists = new ArrayList<>();
        for(int i = 0;i < n; i++) {
            adjLists.add(new ArrayList<>());
        }
        for(int[] pair : edges) {
            adjLists.get(pair[0]).add(pair[1]);
            adjLists.get(pair[1]).add(pair[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        return dfsValid(adjLists,0, -1, visited) && visited.size() == n;
        
    }
    
    private static boolean dfsValid(List<List<Integer>> adjList , int i, int parent, Set<Integer>  visited) {
        if(visited.contains(i)) {
            return false;
        }
        
        visited.add(i);
        for(int j=0; j<adjList.get(i).size(); j++) {
            if(adjList.get(i).get(j) == parent) {
                continue;
            } 
            if(!dfsValid(adjList, adjList.get(i).get(j), i, visited)) {
                return false;
            }
        }
        
        return true;
    }
}
