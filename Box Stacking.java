class Solution {
    static class Box{
        int h,l,w;
        Box(int h, int l, int w){
            this.h = h;
            this.l = Math.max(l, w);
            this.w = Math.min(l, w);
        }
    }
    // int[] dp;
    // int solve(int i, Box[] bx){
    //     if(dp[i] != -1){
    //         return dp[i];
    //     }
    //     int ans = bx[i].h;
    //     for(int j = 0;j<bx.length;j++){
    //         if(bx[j].l<bx[i].l &&
    //         bx[j].w<bx[i].w){
    //             ans = Math.max(ans, bx[i].h + solve(j, bx));
    //         }
    //     }
    //     return dp[i] = ans;
    // }
    public int maxHeight(int[] height, int[] width, int[] length) {
        // Code here
        int n = height.length;
        Box[] bx = new Box[3*n];
        int k = 0;
        for(int i=0;i<n;i++){
            bx[k++] = new Box(height[i],width[i],length[i]);
            bx[k++] = new Box(width[i],height[i],length[i]);
            bx[k++] = new Box(length[i],height[i],width[i]);
          
        }
        int m = bx.length;
        Arrays.sort(bx, (a,b)->{
            if(a.l != b.l) {return Integer.compare(b.l , a.l);}
            return Integer.compare(b.w , a.w);
        });
        
        int dp[] = new int[m];
        int ans = 0;
        for(int i=0;i<m;i++){
            dp[i] = bx[i].h;
            for(int j=0;j<i;j++){
                if(bx[j].l > bx[i].l && bx[j].w > bx[i].w){
                    dp[i] = Math.max(dp[i], bx[i].h + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
