class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        // Code here
        int MOD = 1000000007;
        int n = grid.length;
        int[] nxtWay = new int[n];
        int[] nxtAdv = new int[n];
        Arrays.fill(nxtAdv, -1);
        for(int i=n-1;i>=0;i--){
            int[] curWay = new int[n];
            int[] curAdv = new int[n];
            Arrays.fill(curAdv, -1);
            
            for(int j = n-1;j>=0;j--){
                if(i==n-1&&j==n-1){
                    curWay[j] = 1;
                    curAdv[j] = grid[i][j];
                    continue;
                }
                
                long totalWays = 0;
                int maxAdv = -1;
                int celVal = grid[i][j];
                
                if(celVal == 1 || celVal == 3){
                    if(j+1<n&&curAdv[j+1]!=-1){
                        totalWays = (totalWays+curWay[j+1]) % MOD;
                        maxAdv = Math.max(maxAdv, grid[i][j] + curAdv[j+1]);
                    }
                }
                if(celVal == 2 || celVal == 3){
                    if(i+1<n && nxtAdv[j] != -1){
                        totalWays = (totalWays+nxtWay[j]) % MOD;
                        maxAdv = Math.max(maxAdv, grid[i][j] + nxtAdv[j]);
                    }
                }
                curWay[j] = (int)totalWays;
                curAdv[j] = maxAdv;
            }
            nxtWay  = curWay;
            nxtAdv = curAdv;
        }
        int fp = nxtWay[0];
        int fa = (nxtAdv[0] == -1)?0:nxtAdv[0];
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(fp);
        ans.add(fa);
        return ans;
    }
}
