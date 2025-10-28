class Solution {
    private void dfs(int i ,int[] vis,List<List<Integer>> adj){
        vis[i]=1;
        for(int nei: adj.get(i)){
            if(vis[nei]==0) dfs(nei,vis,adj);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        int count = 0;
        int[] vis = new int[n];
        for(int i =0;i<n;i++){
            if(vis[i]==0) {
                dfs(i,vis,adj); 
                count++;
            }
        }
        System.out.println(count);
        
        if(count!=1) return false;
     
        return true;
        
        
    }
}