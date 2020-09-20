class Solution {
    
    public int uniquePathsIII(int[][] grid) {
        if( grid.length == 0 || grid[0].length == 0 )
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean [m][n];
        
        int dir[][] = {
            {1 , 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        
        int invalid = 0, sr = 0, sc = 0;
        
         for(int i = 0; i < m; i++)
         {
             for(int j = 0; j < n; j++)
             {
                 if(grid[i][j] == -1)
                    invalid++;
                 else if( grid[i][j] == 1 )
                 {
                     sr = i;
                     sc = j;
                 }
             }
         }
        
        
        return upHelper(grid, sr, sc, 1, vis, dir, invalid);
    }
    
    int upHelper( int grid[][], int sr, int sc, int traversed, boolean vis[][], int dir[][], int invalid )
    {
        if( traversed == grid.length * grid[0].length-invalid  && grid[sr][sc] == 2)
        {
            return 1;
        }
        
        vis[sr][sc] = true;
        
        int count = 0;
        
        for(int d = 0;  d < 4; d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if( r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] != -1 && !vis[r][c] )
            {
                count += upHelper( grid, r, c, traversed + 1, vis, dir, invalid );
            }
            
        }
        
        vis[sr][sc] = false;
        return count;
    }
}