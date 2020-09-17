class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXor = 0, n = nums.length;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                maxXor = Math.max( maxXor, ( nums[i] ^ nums[j] ) );
            }
        }
        return maxXor;
    }
}