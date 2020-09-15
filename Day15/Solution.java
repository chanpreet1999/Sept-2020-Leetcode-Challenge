class Solution {
    public int lengthOfLastWord(String s) {
        boolean begin = false;
        int len = 0;
        for(int i = s.length()-1; i >= 0; i--)
        {
            if(s.charAt(i)== ' ')
            {
                if(begin)
                    return len;
            }
            else
            {
                begin = true;
                len++;
            }
        }
        return len;
    }
}