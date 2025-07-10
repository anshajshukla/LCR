class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];

        dp[0]=0;
        dp[1]=0;

        for(int i =2;i<n+1;i++){
            int onestep = dp[i-1]+cost[i-1];
            int twostep = dp[i-2]+cost[i-2];

            dp[i] = Math.min(onestep,twostep);
        }
        return dp[n];
    }
}