class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums) sum+=i;
        int tar = (int) (sum/2);
        // If sum is odd, can't partition
        if (sum % 2 != 0) return false;
        boolean dp[][] = new boolean[nums.length+1][tar+1];
        // BASE CASE FORGOT
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for(int i =1;i<=nums.length;i++){
            for(int j =1;j<=tar;j++){
                if(nums[i-1]<=j) dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                else dp[i][j] = dp[i-1][j];

            }
        }
        return dp[nums.length][tar];
        

        
    }
}