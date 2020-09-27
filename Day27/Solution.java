class Solution {
    class pair{
        String v;
        double w;
        pair(String v, double w)
        {
            this.v = v;
            this.w = w;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) 
    {
        Map<String, ArrayList<pair> > graph = createGraph(equations, values, queries);
        int n = queries.size();
        double ans[] = new double[n];
    
        for(int i = 0; i < n; i++)
        {
            ans[i] = dfs( graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>() );
        }
        return ans;
    }
    
    private double dfs(Map<String, ArrayList<pair>> graph, String src, String dest, Set<String> vis)
    {
        if( !graph.containsKey( src ) || !graph.containsKey( dest ) )
            return -1.0;
        
        if( src.equals(dest) )
            return 1.0;
            
        vis.add( src );
        
        for( pair e : graph.get( src ) )
        {
            if( !vis.contains(e.v) )
            {
                double ans  = dfs( graph, e.v, dest, vis );
                if(ans != -1.0)
                    return ans * e.w;
            }
        }
        return -1.0;
    }
    
    
    
    private Map<String, ArrayList<pair> > createGraph(List<List<String>> equation, double[] values, List<List<String>> queries)
    {
        Map<String, ArrayList<pair>> graph = new HashMap<>();   //create a hashmap as the keys can be arbitrary
        for(int i = 0; i < values.length; i++)
        {
            String u = equation.get(i).get(0);
            String v = equation.get(i).get(1);
            double w = values[i];
            
            graph.putIfAbsent( u, new ArrayList<pair>() );
            graph.putIfAbsent( v, new ArrayList<pair>() );
            
           graph.get(u).add( new pair( v, w  ) );   //it is a directed graph as wt(u->v) != wt(v->u)
            
           graph.get(v).add( new pair( u, 1.0/w  ) );
           
        }
        return graph;
    }
}