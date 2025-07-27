class Solution {
    public int subarraySum(int[] a, int k) {
        Map<Integer,Integer> h = new HashMap<>();
        h.put(0,1);
        int p = 0;
        int c =0;
        for(int i:a){
            p=p+i;
            c+=h.getOrDefault(p-k,0);
            h.put(p,h.getOrDefault(p,0)+1);            
        }
        System.gc();
        return c;
    }
}