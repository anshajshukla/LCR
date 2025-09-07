class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i = i;
            this.j=j;
        }
    }
    private void dfs(int i,int j,int[][]grid){
        int m = grid.length;
        int n = grid[0].length;
        if(i>-1 && j>-1 && i<m && j<n && grid[i][j]==1){
            grid[i][j]=0;
            dfs(i+1,j,grid);
            dfs(i-1,j,grid);
            dfs(i,j+1,grid);
            dfs(i,j-1,grid);
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++) if(grid[i][0]==1) dfs(i,0,grid);
        for(int i=0;i<m;i++) if(grid[i][n-1]==1) dfs(i,n-1,grid);
        for(int j=0;j<n;j++) if(grid[0][j]==1) dfs(0,j,grid);
        for(int j=0;j<n;j++) if(grid[m-1][j]==1) dfs(m-1,j,grid);
        int e =0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j));
                    grid[i][j]=0;
                    int count=1;
                    while(!q.isEmpty()){
                    Pair p = q.poll();
                    int x= p.i;
                    int y = p.j;
                    int [][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
                    for(int [] dir : directions){
                        int nx = x+dir[0];
                        int ny = y+dir[1];

                        if(nx>-1 && nx<m && ny>-1 && ny<n && grid[nx][ny]==1){
                            count++;
                            grid[nx][ny]=0;
                            q.add(new Pair(nx,ny));
                        }
                    }
                }
                e += count;
            }
            }
        }
        return e; 
    }
}