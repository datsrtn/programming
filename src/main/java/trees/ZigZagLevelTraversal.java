package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

    }
        public static void main(String[] args) {
            /*
                3
               / \
              9  20
                /  \
               15   7
  [
   [3],
   [20, 9],
   [15, 7]
 ]
 */
            TreeNode A = new TreeNode(3);
            A.left = new TreeNode(9);
            A.right = new TreeNode(20);
            A.right.left = new TreeNode(15);
            A.right.right = new TreeNode(7);

            System.out.println(zigzagLevelOrder(A));
        }

        public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

            Queue<TreeNode> queue = new LinkedList<>();

            ArrayList<ArrayList<Integer>> retVal = new ArrayList<ArrayList<Integer>>();

            int currLevel = 1;
            queue.add(A);
            while (!queue.isEmpty()) {
                int n = queue.size();
                ArrayList<Integer> tmpListCurrLevel = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    tmpListCurrLevel.add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                if (currLevel % 2 == 0)
                    Collections.reverse(tmpListCurrLevel);
                retVal.add(tmpListCurrLevel);

                currLevel++;
            }
            return retVal;
        }
    }

