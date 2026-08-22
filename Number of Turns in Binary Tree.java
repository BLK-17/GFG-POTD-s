/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    static Node findLCA(Node root, int p, int q){
        if(root==null) return null;
        if(root.data == p || root.data == q)    return root;
        
        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);
        
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
    static boolean findPath(Node root, int target, StringBuilder path){
        if(root == null)    return false;
        if(root.data == target) return true;
        path.append('L');
        if(findPath(root.left, target, path))    return true;
        path.deleteCharAt(path.length()-1);
        
        path.append('R');
        if(findPath(root.right, target, path))  return true;
        path.deleteCharAt(path.length()-1);
        return false;
    }
    static int countTurns(String path){
        int turns = 0;
        for(int i=1;i<path.length();i++){
            if(path.charAt(i)!=path.charAt(i-1))    turns++;
        }
        return turns;
    }
    
    public int numberOfTurns(Node root, int p, int q) {
        // code here
        Node lca = findLCA(root, p, q);
        if(lca == null) return -1;
        
        StringBuilder pathFirst = new StringBuilder();
        StringBuilder pathSecond = new StringBuilder();
        
        findPath(lca, p, pathFirst);
        findPath(lca, q, pathSecond);
        
        int turns = 0;
        
        if(lca.data == p||lca.data == q){
            String path = (lca.data == p)?pathSecond.toString(): pathFirst.toString();
            
            turns = countTurns(path);
        }
        else{
            turns = countTurns(pathFirst.toString()) + countTurns(pathSecond.toString())+1;
        }
        return turns == 0 ? -1 : turns;
    }
}
