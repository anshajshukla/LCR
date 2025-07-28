class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i :nums){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> mh = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());

        for(Map.Entry<Integer,Integer> v : m.entrySet()){
            mh.offer(v);
            if(mh.size()>k){
                mh.poll();
            }
        }
        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=mh.poll().getKey();   
        }
        return ans;
        
    }
}