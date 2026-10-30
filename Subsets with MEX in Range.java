class Solution {
    static final long MOD = 1000000007L;
    public int cntSubsets(int arr[], int l, int r) {
        // code here
        int n = arr.length;
        int[] freq = new int[n+1];
        for(int x:arr){ freq[x]++;}
        long[] pow2 = new long[n+1];
        pow2[0] = 1;
        for(int i=1;i<=n;i++){
            pow2[i] = (pow2[i-1]*2)%MOD;
        }
        long[] prefix = new long[n+1];
        prefix[0] = 1;
        for(int i=0;i<n;i++){
            prefix[i+1] = (prefix[i] * (pow2[freq[i]] - 1+MOD)) %MOD;
        }
        int grt = n;
        long ans = 0;
        for(int i=0;i<=n;i++){
            grt -= freq[i];
                if(i>=l && i<=r){
                    long ways = (prefix[i] * pow2[grt])%MOD;
                    ans = (ans + ways) %MOD;
                }
            }
        return (int) ans;
        
    }
}
