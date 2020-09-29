class Solution {
    Map<String, Boolean> dp;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> hs = new HashSet<>();   //faster search
        dp = new HashMap<>();
        
        for(String str : wordDict)
            hs.add(str);

        return isValid(s, hs);
    }
    
    public boolean isValid( String str,HashSet<String> hs )
    {
        if( str.length() == 0)
            return true;
        
        if( dp.containsKey( str ) ) // memo
            return dp.get(str);
        
        for(int i = 1; i <= str.length(); i++)
        {
            String temp = str.substring( 0, i );
            if( hs.contains( temp ) )
            {
                boolean res = isValid( str.substring(i), hs);
                if(res)
                {
                    dp.put( str, true );     //save ans
                    return true;
                }
                    
            }
        }       
        dp.put( str, false );   //save ans
        return false;
    }
}