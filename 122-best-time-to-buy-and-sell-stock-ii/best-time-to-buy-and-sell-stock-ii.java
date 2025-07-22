class Solution {
    public int maxProfit(int[] p) {
        Integer dp[][] = new Integer [p.length+1][2];
        return f(0,1,p,dp);        
    }
    private int f(int ind, int buy,int[]p,Integer dp[][]){
        int profit = 0;
        if(dp[ind][buy]!=null) return dp[ind][buy];
        if(ind==p.length) return 0;
        if(buy==1){
            profit = Math.max(-p[ind]+f(ind+1,0,p,dp),0+f(ind+1,1,p,dp));
        }
        else{
            profit = Math.max(p[ind]+f(ind+1,1,p,dp),0+f(ind+1,0,p,dp));

        }
        return dp[ind][buy]=profit;
    }
}