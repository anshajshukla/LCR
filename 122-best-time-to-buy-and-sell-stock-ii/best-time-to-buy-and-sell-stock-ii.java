class Solution {
    public int maxProfit(int[] dp) {
        int n = dp.length;
        int ans = 0;
        for(int i =1;i<n;i++){
            if(dp[i]>dp[i-1]) ans += dp[i]-dp[i-1];
        }
        return ans;
    }
}