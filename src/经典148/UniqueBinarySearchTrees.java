package 经典148;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 返回二叉树的节点
     *
     * @param n
     * @return
     */
    public ArrayList<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return process1(1, n);
    }

    private ArrayList<TreeNode> process1(int i, int j) {
        if (i > j) {
            ArrayList<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }
        ArrayList<TreeNode> res = new ArrayList<>();
        for (int k = i; k <= j; k++) {
            List<TreeNode> left = process1(i, k - 1);
            List<TreeNode> right = process1(k + 1, j);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode head = new TreeNode(k);
                    head.left = leftNode;
                    head.right = rightNode;
                    res.add(head);
                }
            }
        }
        return res;
    }


    /**
     * 返回不同二叉树的个数
     *
     * @param n
     * @return
     */

    public int numTrees(int n) {
        return process(1, n);
    }

    private int process(int i, int j) {
        if (i >= j) {
            return 1;
        }
        int res = 0;
        for (int k = i; k <= j; k++) {
            res += process(i, k - 1) * process(k + 1, j);
        }
        return res;
    }

    public int numTrees1(int n) {
        //dp[i][j] 表示 i~j可以组合的二叉树
        /*
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j >= 0; j--) {
                dp[i][j] = 1;
            }
        }
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i >= 1; i--) {
                for (int k = i; k <= j; k++) {
                    dp[i][j] += dp[i][k - 1] * dp[k + 1][j];
                }
            }
        }

        return dp[1][n];*/
        //dp[i]，只要是节点数相同，组合的结果数也是一样的
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    //根据递归改的动态规划版本


    public static void main(String[] args) {
        UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
        System.out.println(u.generateTrees(3));


    }

}
