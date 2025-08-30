class Solution {
    int result = 0;
    int nonobstacle = 0;
    int m = 0;
    int n=0;
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int s_x =0;
        int s_y = 0;
        for(int i =0;i<m;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j]==1){
                    s_x = i;
                    s_y = j;
                    nonobstacle++;
                }
                if(grid[i][j]==0) nonobstacle++;                
            }
        }
        int count = 0;
        backTrack(grid,count,s_x,s_y);
        return result; 
        
    }
    private void backTrack(int [][] grid , int count, int x , int y){
        if(x<0 || x>=m || y>=n || y< 0 || grid[x][y]==-1 ) return;
        
        if(grid[x][y]==2){
            if(count==nonobstacle) result++;
            return;            
        }
        grid[x][y] = -1;

        int [][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int [] dir : directions){
            int n_x = x+dir[0];
            int n_y = y+dir[1];

            backTrack(grid,count+1,n_x,n_y);
        }

        // reset back 
        grid[x][y]=0;

    }
}