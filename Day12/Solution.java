class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k == 0)
            return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        cs(k , n, 1, ans, smallAns);
        return ans;
    }
    
    void cs( int k, int target, int idx, List<List<Integer>> finalAns, List<Integer> smallAns )
    {
        if( k == 0)
        {
            if(target == 0)
            {
                List<Integer> al = new ArrayList<>(smallAns);
                finalAns.add(al);
            }
            return;
        }
        
        for(int i = idx; i <= 9; i++)
        {
            smallAns.add(i);
            cs( k-1, target-i, i+1, finalAns, smallAns );
            smallAns.remove( smallAns.size()-1 );    
        }
    }
}