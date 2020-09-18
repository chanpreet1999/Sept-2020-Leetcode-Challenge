class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
        
        int n = prices.length;
        int gor[] = new int[n];     //maintain a greater on right array
        int maxAns = 0;
        
        gor[n-1] = prices[n-1];
        
        
        for(int i = n-2; i >= 0; i--)
        {
            gor[i] = Math.max( prices[i], gor[i+1] );
        }
        
        for(int i = 0; i < n-1; i++)
        {
            maxAns = Math.max( maxAns, gor[i] - prices[i] );
        }
        return maxAns;
    }
}