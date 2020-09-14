class Solution {
    // int maxProfit = 0;

    public int rob(int[] nums) {

        if(nums.length == 0)
            return 0;

         // helper_rec(nums, 0, 0);
        
        return helper_dp(nums);
        
    }
    
    /* 
    
    //TLE    
   void helper_rec(int a[], int idx, int profit)
    {
        if( idx >= a.length )
        {
             maxProfit = Math.max( profit, maxProfit );
            return;
        }
        maxProfit = Math.max( profit, maxProfit );
        
        helper( a, idx+2, profit+a[idx] );
        helper( a, idx+1, profit );
    }

*/    
    int helper_dp(int a[]){
        int n = a.length;
        int dp[][] = new int[2][n];
        
        dp[0][0] = a[0];
        dp[1][0] = 0;
        
        for(int i = 1; i < n; i++)
        {
            dp[0][i] = dp[1][i-1] + a[i];
            dp[1][i] = Math.max( dp[0][i-1], dp[1][i-1] );
        }
        
        return Math.max(dp[0][n-1], dp[1][n-1]);
    }
}