class Solution {
    boolean isB = true;
    private void dfs(int i,int[]color,List<List<Integer>> adj){
        for(int j : adj.get(i)){
            if(color[j]==0){
                color[j]=-color[i];
                dfs(j,color,adj);
            }
            else{
                if(color[i]==color[j]) isB = false;
            }
        }


    }
    public boolean possibleBipartition(int n, int[][] g) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());

        for(int [] i : g){
            adj.get(i[0]-1).add(i[1]-1);
            adj.get(i[1]-1).add(i[0]-1);
        }
        int [] color = new int[n];
        for(int i =0;i<n;i++){
            if(color[i]==0) {
                color[i]=1;
                dfs(i,color,adj);
            }
        }
        return isB;


        
    }
}