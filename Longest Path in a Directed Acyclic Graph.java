class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        // code here
      ArrayList<ArrayList<int[]>> g = new ArrayList<>();
      int[] intdeg = new int[V];
      for(int i = 0;i<V;i++){
          g.add(new ArrayList<>());
      }
      for(ArrayList<Integer> ed : edges){
          int u = ed.get(0);
          int v = ed.get(1);
          int wt = ed.get(2);
          
          g.get(u).add(new int[] {v, wt});
          intdeg[v]++;
      }
      Queue<Integer> q = new LinkedList<>();
      for(int i = 0;i<V;i++){
          if(intdeg[i] == 0){
              q.offer(i);
          }
      }
      
      ArrayList<Integer> topOrd = new ArrayList<>();
      while(!q.isEmpty()){
          int n = q.poll();
          topOrd.add(n);
          
          for(int[] it : g.get(n)){
              int v = it[0];
              
              if(--intdeg[v] == 0){
                  q.offer(v);
              }
          }
      }
      int[] dist = new int[V];
      Arrays.fill(dist, Integer.MIN_VALUE);
      dist[src] = 0;
      for(int n : topOrd){
          
          if(dist[n] == Integer.MIN_VALUE) 
                continue;
          
          for(int[] it : g.get(n)){
              int v = it[0];
              int wt = it[1];
              dist[v] = Math.max(dist[v], dist[n]+wt);
          }
      }
      return dist;
    }
}
