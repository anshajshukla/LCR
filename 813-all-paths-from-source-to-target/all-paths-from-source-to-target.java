class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> l = new ArrayList<>();
    private void dfs(int i, List<List<Integer>> adj, boolean[] vis){
        l.add(i);
        if(i==(vis.length-1)) {
            ans.add(new ArrayList<>(l));
        }
        else{
            vis[i] = true;
            for(int e : adj.get(i)) {
                if(!vis[e]) dfs(e,adj,vis);
            }
            vis[i]=false;
        }
        l.remove(l.size()-1);
        
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int i =0;i<n;i++){
            for(int e :graph[i] ){
                adj.get(i).add(e);
            }
        }
        boolean [] vis = new boolean[n];
        dfs(0,adj,vis);     
        return ans;   
    }
}