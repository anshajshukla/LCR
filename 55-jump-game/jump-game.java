class Solution {
    public boolean canJump(int[] nums) {
        boolean dp[] = new boolean[nums.length];
        dp[0]=true; // always start is reacheable
        for(int i=0;i<nums.length;i++){
            if(dp[i]){
            int x = nums[i];
            for(int a = 1;a<=x;a++){
                if(a+i<nums.length) dp[a+i] = true;
            }
            }
        }
        return dp[nums.length-1];
        
    }
}