class Solution {
    public int countWithout(int n, int d) {
        // code here
        // int cnt = 0;
        // for(int i=1;i<=n;i++){
        //     String s = String.valueOf(i);
        //     if(!s.contains(String.valueOf(d))){
        //         cnt++;
        //     }
        // }
        // return cnt;
        String S = String.valueOf(n);
        int len = S.length();
        
        long[][] dp = new long[2][2];
        dp[1][0] = 1;
        for(int i =0;i<len;i++){
            long[][] nxt = new long[2][2];
            int curlim = S.charAt(i)-'0';
            for(int t = 0;t<=1;t++){
                for(int s=0;s<=1;s++){
                    long ways = dp[t][s];
                    if(ways==0) continue;
                    int lim = (t == 1)?curlim:9;
                    for(int dig = 0;dig<=lim;dig++){
                       // int nt = (t==1&&d==curlim)?1:0;
                        int ns = (s==1||dig!=0)?1:0;
                        if(ns==1&&dig==d){
                            continue;
                        }
                        int nt = (t == 1&& dig == curlim)?1:0;
                        
                        nxt[nt][ns] += ways;
                    }
                }
            }
            dp = nxt;
        }
        long ans = dp[0][1]+dp[1][1];
        // for(int t = 0;t<=1;t++){
        //     ans += dp[t][1];
        // }
        return (int) ans;
    }
}
