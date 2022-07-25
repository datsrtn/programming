package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SumOddEvenLevels {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    public static void main(String[] args) {
    /*
         1
      /   \
     2     3
    / \   / \
   4   5 6   7
  /
 8
  Sum of nodes at odd level = 23
 Sum of ndoes at even level = 13
  10
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
        static public int solve(TreeNode A) {

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            int oddLevel = 0;
            int evenLevel = 0;
            int currLevel = 1;
            queue.add(A);
            while (!queue.isEmpty()) {
                int n = queue.size();
                int tmpSum = 0;
                for(int i=0; i<n; i++) {
                    TreeNode node = queue.poll();
                    tmpSum+= node.val;

                    if(node.left != null)
                        queue.add(node.left);
                    if(node.right != null)
                        queue.add(node.right);
                }
                if(currLevel %2 == 0 )
                    evenLevel += tmpSum;
                else
                    oddLevel+= tmpSum;

                currLevel++;
            }
            return (oddLevel-evenLevel);
        }
    }
}
