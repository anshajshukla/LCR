class Solution {
    public int findMaxLength(int[] a) {
        int n = a.length;
        int p = 0;
        int ans = 0;
        Map<Integer,Integer> m = new HashMap<>();
        m.put(0,-1); // this is must for input [0,1]
        // if(a[0]==-1) p=-1;
        // else p=1;
        // m.put(p,0);
        for(int i=0;i<n;i++){ // start from the array 
            if(a[i]==0) p+=-1;
            else p+=1;
            if(m.containsKey(p)){
                ans = Math.max(ans,i-m.get(p));
            }
            else m.put(p,i);
        }
        return ans;       
    }
}