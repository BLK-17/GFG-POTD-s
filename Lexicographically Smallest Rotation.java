class Solution {
    public String lexiString(String s) {
        // code here
        int n = s.length();
        String str = s+s;
        
        int i=0;
        int j=1;
        int k=0;
        while(i<n&&j<n&&k<n){
            char a = str.charAt(i+k);
            char b = str.charAt(j+k);
            
            if(a==b){
                k++;
                continue;
            }
            if(a>b){
                i=i+k+1;
                if(i<=j){
                    i=j+1;
                }
            }else{
                j=j+k+1;
                if(j<=i){
                    j=i+1;
                }
            }
            k=0;
        }
        int st = Math.min(i, j);
        
        return str.substring(st, st+n);

// String ans = s;
// for(int i=1;i<s.length();i++){
//     String rt = s.substring(i) + s.substring(0, i);
//     if(rt.compareTo(ans) < 0){
//         ans = rt;
//     }
// }
// return ans;
    }
}
