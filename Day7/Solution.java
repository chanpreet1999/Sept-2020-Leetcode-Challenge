class Solution {
    public int largestOverlap(int[][] a, int[][] b) {
        int ans = 0;
        int rows = a.length;
        int cols = a[0].length;
        for(int r = -rows + 1; r < rows; r++)
        {
            for(int c = -cols+1; c < cols; c++)
            {
                ans =Math.max( ans, oneOverlap( a, b, r, c ) );
            }
        }
        return ans;
    }
    
    int oneOverlap(int a[][], int b[][], int ro, int co)
    {
        int count = 0;
        int len = a.length;
        int ans = 0;
        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < len; j++)
            {
                if(  i + ro < 0 || i + ro >= len || j + co < 0 || j+co >= len )
                    continue;
                if( a[i][j] + b[i + ro][j + co] > 1 )
                    ans++;
            }
        }
        return ans;
    }
}