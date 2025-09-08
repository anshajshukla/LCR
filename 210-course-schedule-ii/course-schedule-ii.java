class Solution {
    public int[] findOrder(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int [] e : edges){
            adj.get(e[1]).add(e[0]);
        }
        int[] indeg = new int[n];
        for(int i=0;i<n;i++){
            for(int j:adj.get(i)) indeg[j]++;
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int k:adj.get(node)){
                indeg[k]--;
                if(indeg[k]==0) q.add(k);
                
            }
            
        }
        if(ans.size()!=n) return new int[0];
        int [] arr = new int[n];
        for(int x=0;x<n;x++){
            arr[x] = ans.get(x);
        }
        return arr;
        
        
        
    }
}