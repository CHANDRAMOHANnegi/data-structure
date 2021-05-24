package generic_trees;

import java.util.*;

public class Main {
	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	public static void display(Node node) {
		String str = node.data + " ---> ";
		ArrayList<Node> children = node.children;
		for (Node child : children) {
			str += child.data + ",";
		}
		str += ".";
		System.out.println(str);
		for (Node child : children) {
			display(child);
		}
	}

	public static int size(Node root) {
		if (root == null) {
			return 0;
		}
		int total = 0;
		for (Node child : root.children) {
			total += size(child);
		}
		total += 1;
		return total;
	}

	public static int max(Node root) {
		int max = root.data;
		for (Node child : root.children) {
			int tmax = max(child);
			if (tmax > max) {
				max = tmax;
			}
		}
		return max;
	}

	public static int height(Node root, int h) {
		if (root == null) {
			return h;
		}
		int maxh = h;
		for (Node child : root.children) {
			int nh = height(child, h + 1);
			if (nh > maxh) {
				maxh = nh;
			}
		}
		return maxh;
	}

	public static int height2(Node root) {
		int maxh = 0;
		for (Node child : root.children) {
			int nh = height2(child);
			if (nh > maxh) {
				maxh = nh;
			}
		}
		return maxh + 1;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };

		Node root = null;
		Stack<Node> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				stack.pop();
			} else {
				Node t = new Node();
				t.data = arr[i];
				if (stack.size() > 0) {
					stack.peek().children.add(t);
				} else {
					root = t;
				}
				stack.push(t);
			}
		}
		// display(root);
		// System.out.println(size(root));
		// System.out.println(max(root));
		System.out.println(height(root, 0));
		System.out.println(height2(root));
	}

}
