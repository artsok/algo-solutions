package io.sokovets.leetcode.easy.easy;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SearchInABinarySearchTree {

    TreeNode search(TreeNode root, int search) {
        if (root == null) {
            return root;
        }

        int value = root.val;
        if (value == search) {
            return root;
        }

        if (value > search) {
            return search(root.left, search);
        } else {
            return search(root.right, search);
        }
    }

    public static void main(String[] args) {
        TreeNode left2 = new TreeNode(1, null, null);
        TreeNode right2 = new TreeNode(3, null, null);
        TreeNode left = new TreeNode(2, left2, right2);
        TreeNode right = new TreeNode(7, null, null);
        TreeNode root = new TreeNode(4, left, right);

        TreeNode searched = new SearchInABinarySearchTree().search(root, 8);
        System.out.println(searched.val);

    }


}
