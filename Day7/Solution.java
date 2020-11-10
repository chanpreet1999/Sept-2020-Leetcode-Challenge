class Solution {
    public boolean wordPattern(String pattern, String str) {
        String words[] = str.split(" ");
        int len = str.length();
        
        if(len != pattern.length())
            return false;
        
        HashMap<Character, String> hm = new HashMap<>();
        
        for(int i = 0; i < len; i++)
        {
            Character ch = pattern.charAt(i);
            if( !hm.containsKey( ch )  )
            {
                if( hm.containsValue( words[i] ) )
                    return false;
                else
                {
                    hm.put( ch, words[i] );
                }
            }
            else
            {
                String val = hm.get(ch);
                if( !val.equals( words[i] ) )
                    return false;
            }
        }
        return true;
    }
}