class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        Integer [][] dp = new Integer[n][m];
        return f(n-1,m-1,text1,text2,dp);       
    }
    private int f(int i1,int i2,String t1,String t2,Integer[][] dp){
        if(i1<0 || i2<0) return 0;
        if(dp[i1][i2]!=null) return dp[i1][i2];
        if(t1.charAt(i1)==t2.charAt(i2)) return 1 + f(i1-1,i2-1,t1,t2,dp);
        return dp[i1][i2]=Math.max(f(i1-1,i2,t1,t2,dp),f(i1,i2-1,t1,t2,dp));
        
    }
}