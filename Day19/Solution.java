class Solution {


    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String str = "123456789";
        for(int l = 2; l <= str.length(); l++ )
        {
            for(int j = 0; j <= str.length() - l; j++ )
            {
                int num = Integer.parseInt( str.substring( j, j+l ) );
                if(num > high)
                    return ans;
                if( num >= low )
                    res.add(ans);
            }
        }
        return ans;
    }


    // correcty ans, but order
    public List<Integer> sequentialDigits(int low, int high) {
        // StringBuilder sb = new StringBuilder();
        // sb.append('1');
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <9 ; i++)
        {
            createAns(i,low, high, ans);
        }
        return ans;
    }
    void createAns( int n, int l, int h, List<Integer> ans )
    {
        int temp = n;
        int sum = 0;
        while( sum < l && n < 10 )
        {
            sum = sum*10 + n;
            n++;
        }
        
        if(temp == 6)
            System.out.println(sum);
        
        while( sum >= l && sum <= h )
        {
            ans.add(sum);
            sum = sum*10 + n;
            
            n++;
            if(n >= 10)
                break;
        }
        
    }
}