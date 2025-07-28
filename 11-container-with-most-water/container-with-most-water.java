class Solution {
    public int maxArea(int[] a) {
        int n = a.length;
        int l = 1;
        int r = n;
        int an = 0;
        while(l<r){
            an = Math.max(an,(r-l)*Math.min(a[r-1],a[l-1]));
            if(a[r-1]>a[l-1]){
                l++;
            }
            else if (a[r-1]<a[l-1]) r--;
            else{
                int la =0;
                if(l+1<r) {
                    la = Math.min(a[r-1],a[l]);
                }
                int ra = 0;
                if(r-1>l && r>=2) {
                    ra = Math.min(a[r-2],a[l-1]);
                }
                an = Math.max(an,Math.max(ra,la));
                l++;
                r--;
            }
        }
        return an;
    }
}