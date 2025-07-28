class Solution {
    public int minSubArrayLen(int t, int[] a) {
        int l=0;
        int min = (int)1e9;
        int s = 0;
        for(int r=0;r<a.length;r++){
            s+=a[r];
            while(s>=t){ 
                min = Math.min(min,r-l+1);              
                s= s-a[l];
                l++;
                
            }

        }
        System.gc();
        return (min==(int)1e9) ? 0:min;


        
    }
}