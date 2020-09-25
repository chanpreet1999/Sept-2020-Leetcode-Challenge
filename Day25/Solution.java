class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        String strArr[] = new String[n];
        
        for(int i = 0; i < n; i++)
            strArr[i] = String.valueOf( nums[i] );
        
        Arrays.sort( strArr, (a, b) -> {
            return -1 * (a+b).compareTo(b+a);   //decending order
        } );
        
        for(String str : strArr)
        {
            sb.append( str );
        }
        
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}