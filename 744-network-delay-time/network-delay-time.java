class Solution {
    class Pair{
        int node;
        int dis;
        Pair(int node,int dis){
            this.node= node;
            this.dis= dis;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<Pair>());
        for(int e[] : times){
            adj.get(e[0]).add(new Pair(e[1],e[2]));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.dis - b.dis);
        pq.add(new Pair(k,0));
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.dis;

            // important removes outdated entries 
            if(d>dist[u]) continue;

            for(Pair p : adj.get(u)){
                int v = p.node;
                int w = p.dis;

                
                if(dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    pq.offer(new Pair(v,dist[v]));
                }        
            }
        }
        int ans = 0;
        for(int i = 1;i<=n;i++) ans = Math.max(ans,dist[i]);
        return (ans==Integer.MAX_VALUE) ? -1:ans;        
    }
}