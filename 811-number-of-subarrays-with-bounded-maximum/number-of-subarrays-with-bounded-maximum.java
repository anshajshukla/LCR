// decomposition based two pointer approach
class Solution {
    private static long tsub(int n ){
        return (long)n*(n+1)/2;
    }
    private static int f(int [] nums, int k ){
        // to find number of subarrays if the breaker is the kth element
        int total = 0;
        int streak =0;
        for(int i : nums){
            if(i<=k) streak++;
            else{
                total +=tsub(streak);
                streak = 0;
            }
        }
        total +=tsub(streak);
        return total;
    }
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return f(nums,right) - f(nums,left-1);

        
    }
}