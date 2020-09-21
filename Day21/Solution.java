class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips.length == 0 )
            return false;
        
        int n = trips.length;
        int maxSize = 0;        
        for(int i = 0; i < n; i++)
        {
            maxSize = trips[i][2] > maxSize ? trips[i][2] : maxSize;        //get the maximum end index
        }
        
        int dp[] = new int[maxSize + 1];
        
        for(int i = 0; i < n; i++)
        {
            int w = trips[i][0];
            int s = trips[i][1];
            int e = trips[i][2];
            
            dp[s] += w;     //the current element will have effect from the start the end point of his journey
            dp[e] -= w;
        }
        
        for(int i = 1; i < maxSize+1; i++)
        {
            dp[i] += dp[i-1];       //prefix sum -> it tells us about  the no of passengers at any piunt in out journey
            if(dp[i] > capacity)    
                return false;
        }
        return true;
    }
}