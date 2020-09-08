class Solution {
    int maxAns = -1;
    public String largestTimeFromDigits(int[] a) {
        permute( a, 0, new boolean [a.length], new int [a.length] );
        return maxAns == -1 ? "" : createAns();
    }
    
    void permute( int[] a, int count, boolean[] visited, int tempAns[]  )
    {
        if(count == a.length)
        {
            isValid(tempAns);    
            return;
        }
        
        for(int i = 0; i < a.length; i++)
        {
            if( !visited[i] )
            {
                visited[i] = true;
                tempAns[count] = a[i];
                permute( a, count+1, visited, tempAns );
                visited[i] = false;
                tempAns[count] = 0;
            }
        }
    }
    
    void isValid( int a[] )
    {
        int h1 = a[0];
        int h2 = a[1];
        int m1 = a[2];
        int m2 = a[3];
        
        int hr = h1*10 + h2;
        int min = m1*10 + m2;
        if(hr > 23 || min > 59)
            return;
        maxAns = Math.max( maxAns, hr * 60 + min );
    }
    
    String createAns()
    {
        String hr = String.format("%02d",maxAns/60);
        String min = String.format( "%02d", maxAns%60 );
        return hr + ":" + min;
    }
}