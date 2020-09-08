class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if( k <= 0 || nums.length == 0)
        {
            return false;
        }
        TreeSet<Long> ts = new TreeSet<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            Long f = ts.floor( 1L * nums[i] + t );
            Long c = ts.ceiling( 1L * nums[i] - t );
            if(f != null && f >= nums[i])
                return true;
            else if(c != null && c <= nums[i])
                    return true;
            ts.add( 1L * nums[i] );
            if(i >= k)
                ts.remove( 1L * nums[i-k] );
        }
        return false;
    }
}