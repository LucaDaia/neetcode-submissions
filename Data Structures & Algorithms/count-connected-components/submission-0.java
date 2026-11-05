class Solution {
    List<List<Integer>> adjList = new ArrayList();
    public int countComponents(int n, int[][] edges) {

        for(int i=0;i<n;i++) {
            adjList.add(new ArrayList());
        }
        for(int i=0; i<edges.length;i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        int res = 0;


        for(int node = 0; node< n; node++) {
            if(!visited[node]) {
            dfs(node, adjList.get(node), visited);
            res++;
            }
        }

        return res;

    }

    public void dfs(int node, List<Integer> adj, boolean[] visited) {
        visited[node] = true;

        for(Integer nei: adj) {
            if(!visited[nei]) {
                dfs(nei, adjList.get(nei), visited);
            }
        }
    }
}
