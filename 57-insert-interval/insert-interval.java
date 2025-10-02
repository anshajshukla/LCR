class Solution {
    public int[][] insert(int[][] in, int[] ni) {
        int n = in.length;
        int i =0;
        ArrayList<int[]> l = new ArrayList<>();
        while(i<n && in[i][1]<ni[0]){
            l.add(in[i]);
            i++;
        }
        while(i<n && in[i][0]<=ni[1] ){
            ni[0] = Math.min(in[i][0],ni[0]);
            ni[1] = Math.max(in[i][1],ni[1]);
            i++;
        }
        l.add(ni);
        while(i<n){
            l.add(in[i]);
            i++;
        }
        return l.toArray(new int[l.size()][]);

        

        
    }
}