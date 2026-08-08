class Solution {
        public static int find(int x, int[] parent){
            if(parent[x] != x){
                parent[x] = find(parent[x], parent);
            }
            return parent[x];
        }
        // code here
        public static int minEdgesReq(int n, int[][] edges){
            if(edges.length<n-1){
                return -1;
            }
            int[] parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
            
            int[] size = new int[n];
            Arrays.fill(size, 1);
            
            for(int[] e: edges){
                int ru = find(e[0], parent);
                int rv = find(e[1], parent);
                
                if(ru == rv){
                    continue;
                }
                
                if(size[ru] < size[rv]){
                    swap(size, ru, rv);
                }
                parent[rv] = ru;
                size[ru] += size[rv];
            }
            
            int components = 0;
            for(int i = 0;i<n;i++){
                if(find(i, parent) == i){
                    components++;
                }
            }
            return components -1;
        }
        private static void swap(int[] size, int a, int b){
            int temp = size[a];
            size[a] = size[b];
            size[b] = temp;
        }
}
