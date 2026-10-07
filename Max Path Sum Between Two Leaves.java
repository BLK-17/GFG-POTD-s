/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    
    int ans = Integer.MIN_VALUE;
    int maxPath(Node root){
        if(root == null) return 0;
        
        int l = maxPath(root.left);
        int r = maxPath(root.right);
        
        if(root.left != null && root.right != null){
            ans = Math.max(ans, l+root.data+r);
        }
        if(root.left == null)   return root.data + r;
        if(root.right == null)  return root.data+l;
        return root.data + Math.max(l, r);
    }
    public int maxPathSum(Node root) {
        // code here
        maxPath(root);
        
        if(ans == Integer.MIN_VALUE)    return -1;
        return ans;
    }
}
