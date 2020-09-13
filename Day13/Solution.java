class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0 && newInterval == null) 
            return new int[][]{};
        
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        
        while( i < n  && intervals[i][1] < newInterval[0] )
        {
            ans.add(intervals[i]);
            i++;
        }
        
        if( i < n && newInterval[1] < intervals[i][0] )
        {
            ans.add(newInterval);
        }
        else
        {
        int start = (i < intervals.length) ? Math.min( newInterval[0], intervals[i][0] ) : newInterval[0];
        int end = (i < intervals.length) ? Math.max( newInterval[1], intervals[i][1] ) : newInterval[1];
        
        while(i < n && end >= intervals[i][0])
        {
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        
        ans.add(new int[] {start, end});
        
        }
        
        while( i < n)
        {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][2]);
        
    }
}