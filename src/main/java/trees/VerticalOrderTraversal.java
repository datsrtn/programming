package trees;

import java.util.*;

public class VerticalOrderTraversal {
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
    static class QueueData {
        TreeNode node;
        int level;
        public QueueData(TreeNode t, int level) {
            this.node = t;
            this.level = level;
        }
    }
    public static void main(String[] args) {
        /*
      6
    /   \
   3     7
  / \     \
 2   5     9

  [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
         */
        TreeNode A = new TreeNode(6);
        A.left = new TreeNode(3);
        A.left.left = new TreeNode(2);
        A.left.right = new TreeNode(5);
        A.right = new TreeNode(7);
        A.right.right = new TreeNode(9);
        System.out.println(verticalOrderTraversal(A));
    }
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> retVal = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> tmpArr = null;
        int currLevel = 0;
        Queue<QueueData> queue = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int minLevel = 100001;
        int maxLevel = -100001;
        if (A == null) {
            return retVal;
        } else {
            queue.add(new QueueData(A, currLevel));
            while (!queue.isEmpty()) {
                int queueSize = queue.size();
                for (int i = 0; i < queueSize; i++) {
                    QueueData t = queue.poll();
                    currLevel = t.level;
                    if (currLevel < minLevel) {
                        minLevel = currLevel;
                    }
                    if (currLevel > maxLevel) {
                        maxLevel = currLevel;
                    }
                    if (map.containsKey(t.level)) {
                        map.get(t.level).add(t.node.val);
                    } else {
                        map.put(t.level, new ArrayList<>(Arrays.asList(t.node.val)));
                    }

                    if (t.node.left != null) {
                        queue.add(new QueueData(t.node.left, currLevel - 1));
                    }
                    if (t.node.right != null) {
                        queue.add(new QueueData(t.node.right, currLevel + 1));
                    }
                }
            }
        }
        for (int i = minLevel; i <= maxLevel; i++) {
            retVal.add(map.get(i));
        }
        return retVal;

    }
}
