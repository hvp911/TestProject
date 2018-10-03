package com;

import java.util.HashSet;

public class TwoSum4 {

	public static void main(String[] args) {
		TwoSum4 twoSum = new TwoSum4();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);

		System.out.println(twoSum.findTarget(root, 8));
	}

	public boolean findTarget(TreeNode root, int k) {
		HashSet<Integer> setNode = new HashSet<Integer>();
		return bstTraversal(root, k, setNode);
	}

	public boolean bstTraversal(TreeNode root, int k, HashSet<Integer> nodeSet) {
		if (root == null) {
			return false;
		}
		if (nodeSet.contains(k - root.val)) {
			return true;
		}
		nodeSet.add(root.val);
		return bstTraversal(root.left, k, nodeSet) | bstTraversal(root.right, k, nodeSet);
	}
}