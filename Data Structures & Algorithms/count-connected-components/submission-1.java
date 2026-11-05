class Solution {
    public int countComponents(int n, int[][] edges) {

        int res = 0;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pair : edges) {
            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }
        
        for(int i=0;i<n;i++) {
            if(visited[i] == false) {
                dfs(i, adj,visited);
                res++;
            }
        }

        return res;
    }

    public void dfs(int node, List<List<Integer>> adj, boolean[] visited) {

        if(visited[node]) {
            return;
        }

        visited[node] = true;
        for(int i: adj.get(node)) {
            if(i == node) continue;

            dfs(i, adj,visited);
        }
    }
}
