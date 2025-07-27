class Solution {
    public int[] productExceptSelf(int[] a) {
        // int n =a.length;
        // int[] p = new int[n];
        // int[] s = new int[n];
        // p[0]=1;
        // s[n-1]=1;
        // for(int i=1;i<n;i++){
        //     p[i]=p[i-1]*a[i-1];
        // }
        // for(int i=n-2;i>-1;i--){
        //     s[i]=s[i+1]*a[i+1];
        // }
        // int ans[] = new int[n];
        // for(int i=0;i<n;i++){
        //     ans[i]=p[i]*s[i];
        // }
        // return ans;    
        int n = a.length;
        int ans[] = new int[n];
        Arrays.fill(ans,1);
        int curr=1;
        for(int i=0;i<n;i++){
            ans[i]*=curr;
            curr*=a[i];
        }
        curr=1;
        for(int i=n-1;i>=0;i--){
            ans[i]*=curr;
            curr*=a[i];
        }
        return ans;
        
    }
}