class Solution {
    public int[] topKFrequent(int[] a, int k) {
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i:a){
            h.put(i,h.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Integer,Integer>> l = new ArrayList<>(h.entrySet());

        l.sort((x,y) -> y.getValue()-x.getValue());  // b-a means highest freq first 

        int []ans = new int[k]; 

        for(int i=0;i<k;i++){
            ans[i] = l.get(i).getKey();
        }
        return ans;
        
    }
}