class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum =0,target=0;
        for(int num : nums) sum+=num; 
        if (sum%2!=0) return false;
        else target = sum/2;
        int [][] dp = new int[n][target+1]; 
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return f(n-1,target,nums,dp);
        
    }
    private boolean f(int ind, int target , int [] nums,int [][]dp){
        if(target==0) return true;
        if(ind==0) return target==nums[0];
        if(dp[ind][target]!=-1) return dp[ind][target] == 0 ? false : true;


        boolean nottake= f(ind-1,target,nums,dp);
        boolean take = false;
        if(nums[ind]<=target) take = f(ind-1,target-nums[ind],nums,dp);

        dp[ind][target] = nottake || take ? 1 : 0;
        return nottake || take;
    }
}