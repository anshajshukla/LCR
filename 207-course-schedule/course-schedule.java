class Solution {
    private boolean dfs(int i,List<List<Integer>> adj,boolean[] vis,boolean[] pvis){
        vis[i] = true;
        pvis[i] = true;
        for(int node : adj.get(i)){
            if(!vis[node]) {
                if(dfs(node,adj,vis,pvis)) return true;
            }
            else if(pvis[node]) return true;
            
        }
        pvis[i]=false;
        return false;
    } 
    public boolean canFinish(int n, int[][] p) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int [] e : p){
            adj.get(e[0]).add(e[1]);
        }
        boolean[] vis = new boolean[n];
        boolean[] pvis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfs(i,adj,vis,pvis)) return false;
            }
        }
        return true;
        
    }
}
