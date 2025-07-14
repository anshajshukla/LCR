class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        Integer dp[][] = new Integer[len][len];
        return f(0,len-1,s,dp);
    }
    private int f(int s, int l, String st, Integer[][]dp){
        if(s>l) return 0;
        if(s<0 || l <0) return 0;
        if(s==l) return 1;
        if(dp[s][l]!=null) return dp[s][l];
        if(st.charAt(s)==st.charAt(l)) return 2+f(s+1,l-1,st,dp);
        else return dp[s][l]=Math.max(f(s+1,l,st,dp),f(s,l-1,st,dp));
    }
}