class Solution {
    public int maxSubArray(int[] nums) {
        // // Prefix sum 
        // int[]p = new int[nums.length+1];
        // p[0]=0;
        // int min = 0;
        // int max = 0;

        // for(int i =1;i<=nums.length;i++){
        //     p[i]=p[i-1]+nums[i-1];
        //     min = Math.min(min,p[i]);
        //     max = Math.max(max,p[i]);
        // }
        // System.out.println(max);
        // System.out.println(min);
        // return max-min;
        
        int ans= Integer.MIN_VALUE;
        int p =0;
        int minp=0;

        for(int i:nums){
            p+=i;
            // first max prefix will come then min prefix --> to maintain subarrat
            ans = Math.max(ans,p-minp);
            minp = Math.min(minp,p);
        }
        return ans;
    }
}