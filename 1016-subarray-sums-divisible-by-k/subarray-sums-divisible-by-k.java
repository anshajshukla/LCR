class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int [] p = new int[n+1];
        p[0]=0;
        int ans = 0;
        HashMap<Integer,Integer> h = new HashMap<>();
        h.put(0,1);
        for(int i=0;i<n;i++){
            p[i+1]= nums[i]+p[i];
            int r = ((p[i+1]%k)+k)%k;
            if(h.containsKey(r)) ans+=h.getOrDefault(r,0);
            System.out.println("rem" + r);
            h.put(r,h.getOrDefault(r,0)+1);

        }
        return ans;
        
    }
}