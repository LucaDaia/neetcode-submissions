class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int res = 0;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        
        // Build undirected graph
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++; // Found a new component
                dfs(i, adjList, visited);
            }
        }
        return res;
    }

    private void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}