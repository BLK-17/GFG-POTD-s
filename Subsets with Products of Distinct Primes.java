class Solution {
    static final int MOD = 1000000007;
    static long pow(long a, long b){
        long ans = 1;
        while(b>0){
            if((b&1)!=0){
                ans = (ans* a)% MOD;
            }
            a = (a*a) %MOD;
            b>>= 1;
        }
        return ans;
    }
    static int getMask(int num){
        int[] primes = {2,3,5,7,11,13,17,19,23,29};
        int  mask = 0;
        for(int i=0;i<10;i++){
            int p = primes[i];
            int cnt = 0;
            while(num%p==0){
                cnt++;
                num /= p;
            }
                if(cnt>1)   return -1;
                if(cnt == 1)    mask |= (1<<i);
        }
        return mask;
    }
    static int countSubsets(int[] nums) {
        // code here
        int[] freq = new int[31];
        Arrays.fill(freq, 0);
        for(int x : nums)  
            freq[x]++;
        
        int ones = freq[1];
        long[] dp = new long[1024];
        Arrays.fill(dp, 0);
        
        dp[0] = 1;
        
        for(int num = 2;num<=30;num++){
            if(freq[num]==0)    continue;
            int curMask = getMask(num);
            if(curMask == -1)   continue;
            
            for(int mask = 1022;mask>=0;mask--){
                if((mask&curMask)!=0)   continue;
                dp[mask | curMask] = (dp[mask|curMask]+dp[mask]*freq[num]%MOD);
            }
        }
        long ans = 0;
        for(int mask = 1;mask<1024;mask++)
            ans = (ans + dp[mask])%MOD;
        ans = (ans * pow(2,ones)) % MOD;
        
        return (int) ans;
    }
}
