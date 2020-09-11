class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return -1;
        int curMax = nums[0], curMin = nums[0], max = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            int temp = curMax;
            curMax = Math.max( Math.max(curMax * nums[i], curMin * nums[i]), nums[i] );
            curMin = Math.min( Math.min(temp * nums[i], curMin * nums[i]), nums[i] );
            
            max = max > curMax ? max : curMax;
        }
        return max;
    }
}