class Solution {
    private int[] maxMin(int[] piles) {
        Arrays.sort(piles);
        return new int[]{piles[0], piles[piles.length-1]};
    }
    
    private int h(int[] piles, int mid) {
        int n = piles.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += Math.ceil((double)piles[i] / mid);  // Cast to double
        }
        return ans;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int[] a = maxMin(piles);
        int s = 0;           // Start from 1, not min value
        int l = a[1];        // Use max value as upper bound
        
        while(s < l) {       // Changed from s > l to s < l
            int mid = s + (l - s) / 2;
            int ans = h(piles, mid);
            
            if(ans <= h) {   // If we can finish in time or less
                l = mid;     // Try smaller speed
            } else {         // If we need more time
                s = mid + 1; // Need faster speed
            }
        }
        return s;           // Return the minimum speed
    }
}
