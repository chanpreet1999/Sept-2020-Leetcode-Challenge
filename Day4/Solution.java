class Solution {
    public List<Integer> partitionLabels(String str) {
           int len = str.length();
           int i = 0;
           List<Integer> ans = new ArrayList<>();
           int lastIndex[] = lastIndexOf(str, len);
   
           while( i < len )
           {
               int si = i;
               int ei = lastIndex[ (int)( str.charAt(i) - 'a' ) ];
               
               for(int j = si+1; j < ei;  j++)
               {
                   char ch = str.charAt(j);
   
                   int lastIdx = lastIndex[ (int) (ch-'a') ];
   
                   ei = ei > lastIdx ? ei : lastIdx;
               }
               ans.add( ei-si+1 );
               i = ei+1;
           }
           return ans;
       }
   
       int[] lastIndexOf( String str,int len )
       {
           int ans[] = new int[26];
           for(int i = 0; i < len; i++)
           {
               int idx = (int) (str.charAt(i) - 'a');
               ans[ idx ] = i;
           }
           return ans;
       }
   
   }