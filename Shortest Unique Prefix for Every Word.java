
class tn{
    tn[] child;
    int freq;
    tn(){
        child = new tn[26];
        freq = 0;
    }
}
class Solution {
    static void insert(tn root, String w){
        tn curr = root;
        for(char ch : w.toCharArray()){
            int idx = ch - 'a';
            if(curr.child[idx] == null) curr.child[idx] = new tn();
            
            curr = curr.child[idx];
            curr.freq++;
        }
    }
    
    static String getPrefix(tn root, String w){
        tn curr = root;
        StringBuilder sb = new StringBuilder();
        for(char ch : w.toCharArray()){
            curr = curr.child[ch-'a'];
            sb.append(ch);
            if(curr.freq == 1){
                break;
            }
        }
        return sb.toString();
    }
    public ArrayList<String> findPrefixes(String[] arr) {
        // code here
        tn root = new tn();
        for(String w : arr){
            insert(root, w);
        }
        
        ArrayList<String> ans = new ArrayList<>();
        for(String w : arr){
            ans.add(getPrefix(root, w));
        }
        return ans;
    }
}
