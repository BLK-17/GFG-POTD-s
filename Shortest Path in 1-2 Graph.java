class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        // code here
        ArrayList<int[]>[] grp = new ArrayList[V];
        
        for(int i=0;i<V;i++){
            grp[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            grp[u].add(new int[]{v,w});
            grp[v].add(new int[]{u,w});
            
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,src});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int d = cur[0];
            int node = cur[1];
            
            if(d>dist[node])    continue;
            if(node == dest)    return d;
            for(int[] nbr : grp[node]){
                int nxt = nbr[0];
                int wt = nbr[1];
                if(dist[nxt]>d+wt){
                    dist[nxt]=d+wt;
                    pq.offer(new int[]{dist[nxt],nxt});
                }
            }
        }
        return -1;
    }
}
