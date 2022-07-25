package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewBinartyTree {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
      right=null;
      }
  }
    public static void main(String[] args) {
        /*
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8
      [1, 2, 4, 8]
         */
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.left.left = new TreeNode(4);
        A.left.left.left = new TreeNode(8);
        A.left.right = new TreeNode(5);
        A.right = new TreeNode(3);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);

        int [] ans =  solve(A);

        for(int currInt : ans) {
            System.out.print(currInt + " ");
        }
    }
    public static int[] solve(TreeNode A) {
        if(A == null)
            return new int[0];

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> retVal = new ArrayList<Integer>();
        queue.add(A);
        while (!queue.isEmpty()) {
            int n = queue.size();
            // Traverse entire list
            for(int  i=0; i < n; i++) {
                TreeNode node = queue.poll();
                // for first Node add to result
                if(i == 0)
                    retVal.add(node.val);
                // add children of all the node to queue
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        return retVal.stream().mapToInt(i->i).toArray();
    }
}
