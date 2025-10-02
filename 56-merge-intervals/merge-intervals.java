class Solution {
    public int[][] merge(int[][] in) {
        int n = in.length;
        ArrayList<int[]> li = new ArrayList<>();
        Arrays.sort(in,(a,b)->a[0]-b[0]);
        int cur [] = new int[2];
        cur[0]= in[0][0];
        cur[1]= in[0][1];
        for(int i =1;i<n;i++){
            int f = in[i][0];
            int l = in[i][1];
            if(cur[1]>=f){
                cur[1] = Math.max(l,cur[1]);
            }
            else {
                li.add(cur);
                cur = in[i];
            }
            
            
        }
        li.add(cur);
        return li.toArray(new int[li.size()][]);
        
        
    }
}