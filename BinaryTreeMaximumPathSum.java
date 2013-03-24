/**
 Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3

Return 6. 
**/

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        Result result = getMaxPathSum(root);
        return result.max;
    }
    
    private Result getMaxPathSum(TreeNode root){
        if(root==null)
            return new Result(Integer.MIN_VALUE,0);
        Result left = getMaxPathSum(root.left);
        Result right = getMaxPathSum(root.right);
        
        Result r = new Result(root.val,root.val);
        //calculate pathMax
        int pathMax = left.pathMax>right.pathMax?left.pathMax:right.pathMax;
        if(pathMax>0)
            r.pathMax=root.val+pathMax;
        //calculate max
        int localMax = left.max>right.max?left.max:right.max;
        if(localMax>r.max)
            r.max=localMax;
        if(root.val>0){
            if(left.pathMax>0 && left.pathMax+root.val>r.max)
                r.max = left.pathMax+root.val;
            if(right.pathMax>0 && right.pathMax+root.val>r.max)
                r.max = right.pathMax+root.val;
        }
            
        if(right.pathMax+left.pathMax+root.val>r.max)
            r.max=right.pathMax+left.pathMax+root.val;
        return r;
    }
}

class Result{
    int max;
    int pathMax;
    
    Result(int a,int b){
        max=a;
        pathMax=b;
    }
}
