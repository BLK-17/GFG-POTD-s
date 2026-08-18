class Solution {
    static void computeLPS(String s,int[] lps) {
        // code here
        int n = s.length();
        
        lps[0] = 0;
        for(int i=1;i<n;i++){
            int len = lps[i-1];
            
            while(len>0 && s.charAt(i) != s.charAt(len)){
                len = lps[len-1];
            }
            
            if(s.charAt(i) == s.charAt(len)){
                len++;
            }
            lps[i] = len;
        }
    }
    
    static String compress(String s){
        int n = s.length();
        
        int[] lps = new int[n];
        
        computeLPS(s, lps);
        
        Stack<Character> st = new Stack<>();
        for(int i=n-1;i>0;i--){
            int len = i+1;
            
            if(len % 2 == 1){
                st.push(s.charAt(i));
                continue;
            }
            
            int lpsf = lps[i];
            boolean cc = false;
            
            int bl = len-lpsf;
            if(lpsf *2 >= len && len % bl == 0 && (len/bl)%2==0){
                cc = true;
            }
            
            if(cc){
                st.push('*');
                i=len/2;
            }
            else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        
        while(!st.isEmpty()){
            ans.append(st.pop());
    }
        return ans.toString();
    }
}
