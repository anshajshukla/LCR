class Solution {
    public int pivotIndex(int[] a) {
        
        int []lp = new int[a.length+1];
        int []rp = new int[a.length+1];
        lp[0]=rp[0]=0;

        for(int i = 0;i<a.length;i++){
            lp[i+1]= a[i]+ lp[i];
            rp[i+1]= a[a.length-1-i]+rp[i];
        }
        
        for(int i = 0;i<a.length;i++){
            if(lp[i]==rp[a.length-i-1]) return i;
        }
        return -1;
    }
}