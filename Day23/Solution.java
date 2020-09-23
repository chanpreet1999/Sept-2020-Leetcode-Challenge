class Solution {
    //O(n2) check for every posibility
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0)
            return -1;
        
        int n = gas.length;
        for(int i = 0; i < n; i++)
        {
            int total = 0, steps = 0, j = i;
            while(steps < n)
            {
                total += gas[j%n] - cost[j%n];
                if(total < 0)
                    break;
                steps++;
                j++;
            }
            if( steps == n && total >= 0)
                return i;
        }
        
        return -1;
    }
}