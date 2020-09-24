class Solution {
    public char findTheDifference(String s, String t) {
        int a[] = new int[26];  //store count of  every character
        int len = s.length();
        for(int i = 0; i < len; i++)    //increment count according to character
        {
            a[ s.charAt(i) - 'a' ]++;
            a[ t.charAt(i) - 'a' ]++;    
        }
        
        a[ t.charAt(len) - 'a' ]++;     //add coint of the extra character
        
        for(int i = 0; i < 26; i++)
        {
            if(a[i] % 2 != 0)           // all the characters will have even count except the oddly added character
                return (char)('a' + i);
        }
        return '!'; //case of failure
    }
}