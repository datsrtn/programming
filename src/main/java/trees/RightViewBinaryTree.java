package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
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
      [1, 3, 7, 8]
         */
            TreeNode A = new TreeNode(1);
            A.left = new TreeNode(2);
            A.left.left = new TreeNode(4);
            A.left.left.left = new TreeNode(8);
            A.left.right = new TreeNode(5);
            A.right = new TreeNode(3);
            A.right.left = new TreeNode(6);
            A.right.right = new TreeNode(7);

            System.out.println(solve(A));

        }
    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> retVal = new ArrayList<Integer>();
        ArrayList<Integer> tmpArr = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(A == null) {
            return retVal;
        } else {
            queue.add(A);
            while( !queue.isEmpty() ) {
                int queueSize=queue.size();
                tmpArr = new ArrayList<Integer>();
                for(int i =0; i < queueSize; i++) {
                    TreeNode t = queue.poll();
                    if(t.left != null) {
                        queue.add(t.left);
                    }
                    if(t.right != null) {
                        queue.add(t.right);
                    }
                    tmpArr.add(t.val);
                }
                retVal.add(tmpArr.get(tmpArr.size()-1));
            }
        }
        return retVal;
    }

}
