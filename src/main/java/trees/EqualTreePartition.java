package trees;

import java.util.HashSet;

public class EqualTreePartition {
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
    static HashSet<Long> hashSet = new HashSet();
    public static void main(String[] args) {
        /*
                5
               /  \
              3    7
             / \  / \
            4  6  5  6
         */
        TreeNode A = new TreeNode(5);
        A.left = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(6);
        A.right = new TreeNode(7);
        A.right.left = new TreeNode(5);
        A.right.right = new TreeNode(6);
        int result =solve(A);
        System.out.println(getSum(A));
        System.out.println(result);

    }


    public static int solve(TreeNode A) {
        return hashSet.contains(getSum(A)/2) ? 1 :0;
    }

    static long getSum(TreeNode  A) {
        if(A == null) return 0;
        long sum =  (getSum(A.left) + getSum(A.right) + A.val) ;
        hashSet.add(sum);
        return sum;
    }
}
