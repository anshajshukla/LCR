class Solution {
    public int superPow(int a, int[] b) {
        int mod = 1337;
        a = a % mod;
        if (a == 1)
            return 1;
        int rem = 1;
        int n = b.length;
        for (int i = 0; i < n; i++) {
            int p2 = pow(a, b[n - i - 1], i);
            rem = (rem * p2) % mod;
        
        }
        return rem;

    }

    private int pow (int a,int b,int m){
        int c = 1;
        int ans = 1;
        for(int i=m;i>=-1;i--){
            if(i==-1) {
                ans  = a;
                break;
            }
            if(c==1) a =  po(a,b);
            else {

                a =po(a,10);
                
            }
            c*=10;
            
        }
        return ans; 
    }

    private int po(int a,int b){
        int mod = 1337;
        int ans = 1;
        while(b>0){
            if((b&1)==1) ans = (ans*a) % mod ;
            a = (a*a) % mod ;
            b >>= 1;
        }
        return ans;
    }
}