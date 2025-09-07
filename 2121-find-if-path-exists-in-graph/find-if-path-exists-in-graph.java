class Solution {
    private void dfs(int m,int source,List<List<Integer>> adj, boolean [] vis){
        vis[source] = true;
        for(int i : adj.get(source)){
            if(!vis[i]) dfs(m,i,adj,vis);
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Building the adjacency List 
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int [] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);            
        }
        boolean []vis = new boolean [n];
        dfs(n,source,adj,vis);
        if(vis[destination]) return true;
        else return false;

    }
}