class Solution {
    private int f(int i, int curr, int[] nums,Integer [][]dp, int offset) {
        if (i < 0) return Math.abs(curr);
        if(dp[i][curr+offset] !=null) return dp[i][curr+offset];
        int pos = f(i - 1, curr + nums[i], nums,dp,offset);
        int neg = f(i - 1, curr - nums[i], nums, dp, offset);
        return dp[i][curr+offset] = Math.min(pos, neg);
    }

    public int lastStoneWeightII(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ni : nums) sum+=ni;
        int offset = sum;
        Integer [][] dp = new Integer[n+1][2*sum+1];
        return f(n - 1, 0, nums,dp,offset);
    }
}
