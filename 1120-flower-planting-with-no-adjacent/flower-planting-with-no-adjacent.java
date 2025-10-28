class Solution {
    void fill(int nei,int[]color,List<List<Integer>> adj){
       
        for(int i =1;i<5;i++){
            boolean canUse = true;
            for(int j : adj.get(nei)){
                if(color[j]==i) {
                    canUse = false;
                    break;
                }
                
            }
            if(canUse) {
                color[nei] = i;
                return;
            }
        }
        

    }
    void dfs(int i ,int[] color, List<List<Integer>> adj){
        for(int nei: adj.get(i)){
            if(color[nei]==0){
                fill(nei,color,adj);
                dfs(nei,color,adj);
            }
        }
    }
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int i[]:paths){
            adj.get(i[0]-1).add(i[1]-1);
            adj.get(i[1]-1).add(i[0]-1);
        }
        int color[] = new int[n];
        for(int i =0;i<n;i++){
            if(color[i]==0){
                color[i]=1;
                dfs(i,color,adj);
            }
        }
        return color;
        
    }
}