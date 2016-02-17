package leetcode;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		TreeNode root1=new TreeNode(1);
		TreeNode root2=new TreeNode(2);
		TreeNode root3=new TreeNode(3);
		TreeNode root4=new TreeNode(4);
		root1.left=root2;
		root1.right=root3;
		root2.left=root4;
		System.out.println(new CountCompleteTreeNodes_222().countNodes(root1));
	}
}
