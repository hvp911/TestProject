package com;

public class ValidateBinarySearchTree {
	public static void main(String[] args) {
		ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(20);
		System.out.println(validateBinarySearchTree.isValidBST(root));
	}

	public boolean isValidBST(TreeNode root) {
		return validateBST(root, root.val);
	}

	public boolean validateBST(TreeNode root, int val) {
		boolean isValid = true;
		if (root == null) {
			return true;
		}
		if (root.left != null && root.right != null) {
			isValid = root.val > root.left.val && root.val < root.right.val;
		} else if (root.left != null) {
			isValid = root.val > root.left.val;
		} else if (root.right != null) {
			isValid = root.val > root.right.val;
		} 
		if (isValid && root.left != null) {
			isValid &= validateBST(root.left, root.val);
		}
		if (isValid && root.right != null) {
			isValid &= validateBST(root.right, root.val);
		}
		return isValid;
	}

}
