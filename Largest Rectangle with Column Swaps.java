class Solution {
    public int maxArea(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] ht = new int[n][m];
        
        for(int j=0;j<m;j++){
            ht[0][j] = mat[0][j];
            
            for(int i = 1;i<n;i++){
                if(mat[i][j] == 1){
                    ht[i][j] = ht[i-1][j]+1;
                }
            }
        }
        
        int ans = 0;
        
        for(int i=0;i<n;i++){
            int[] cnt = new int[n+1];
            
            for(int j = 0;j<m;j++){
                cnt[ht[i][j]]++;
            }
            int col = 0;
            
            for(int h = n;h>=0;h--){
                while(cnt[h] > 0){
                    ht[i][col] = h;
                    col++;
                    cnt[h]--;
                }
            }
            
            for(int j = 0;j<m;j++){
                ans = Math.max(ans, ht[i][j]*(j+1));
            }
        }
        return ans;
    }
}
