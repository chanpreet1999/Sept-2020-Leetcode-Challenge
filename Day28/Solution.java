class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0)
            return 0;
        long product = 1;
        int count = 0, s = 0, e = 0;
        while(e < n)
        {
            product *= nums[e];
            while(s <= e && product >= k)
            {
                product /= nums[s];
                s++;
            }
            if(product <= k)
                count += e-s+1;
            e++;
        }
        return count;
    }
}