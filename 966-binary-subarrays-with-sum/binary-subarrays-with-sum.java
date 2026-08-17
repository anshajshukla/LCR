class Solution {
    public int numSubarraysWithSum(int[] arr, int k) {
        int n = arr.length;
        int [] p = new int[n+1];
        p[0]=0;
        int ans = 0;
        HashMap<Integer,Integer> h = new HashMap<>();
        h.put(0,1);
        for(int i =0;i<n;i++){
            p[i+1]= arr[i]+p[i];
        }

        for(int i=1;i<=n;i++){
            if(h.containsKey(p[i]-k)) ans += h.getOrDefault(p[i]-k,0);
            h.put(p[i],h.getOrDefault(p[i],0)+1);
            
        }
        return ans;
    }
}