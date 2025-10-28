class Solution {
    boolean isValid = true;
    void dfs(int node, int[] color, List<List<Integer>> adj) {
        for (int nei : adj.get(node)) {
            if (color[nei] == 0) {
                color[nei] = -color[node];
                dfs(nei, color, adj);
            } 
            else if (color[nei] == color[node]) {
                isValid = false;
                
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int nei : graph[i]) {
                adj.get(i).add(nei);
            }
        }

        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                dfs(i, color, adj);
            }
        }
        
        return isValid;
        
         

        
    }
}