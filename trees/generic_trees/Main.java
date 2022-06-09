package generic_trees;

import java.util.*;


public class Main {
	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		Node() {

		}

		Node(int data) {
			this.data = data;
		}

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

	public static void traversal(Node node) {

		System.out.println("node pre" + node.data);
		for (Node child : node.children) {
			System.out.println("Edge pre" + node.data + "----->" + child.data);

			traversal(child);

			System.out.println("Edge Post" + node.data + "----->" + child.data);
		}
		System.out.println("node post" + node.data);
	}

	/***
	 * @param node
	 * @param data
	 * @return
	 *
	 */

	public static void levelordertraversal(Node node) {

		Queue<Node> que = new ArrayDeque<>();
		que.add(node);

		while (que.size() > 0) {
			node = que.remove();
			System.out.println(node.data + "  ");
			for (Node child : node.children) {
				// System.out.println(child.data + " ");
				que.add(child);
			}
		}
		System.out.println(".");
	}

	public static void levelorderlinewisetraversal(Node node) {
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(node);

		Queue<Node> cq = new ArrayDeque<>();
		while (mq.size() > 0) {
			node = mq.remove();
			System.out.print(node.data + "  ");
			for (Node child : node.children) {
				cq.add(child);
				// System.out.println(child.data + " ");
			}
			if (mq.size() == 0) {
				mq = cq;
				cq = new ArrayDeque<>();
				System.out.println();
			}
		}
	}

	public static void levelorderlinewiseWithNulltraversal(Node node) {
		ArrayDeque<Node> mq = new ArrayDeque<>();
		mq.add(node);
		mq.add(new Node(-1));

		while (mq.size() > 0) {
			node = mq.remove();

			if (node.data == -1) {
				if (mq.size() > 0) {
					mq.add(new Node(-1));
					System.out.println();
				}
			} else {

				System.out.print(node.data + "  ");

				for (Node child : node.children) {
					mq.add(child);
				}

			}
		}
	}

	public static void levelorderzigzagtraversal(Node node) {
		Stack<Node> ms = new Stack<>();
		ms.push(node);

		int level = 0;
		Stack<Node> cs = new Stack<>();
		while (ms.size() > 0) {
			node = ms.pop();
			System.out.print(node.data + "  ");

			if (level % 2 == 1) {
				for (int i = 0; i < node.children.size(); i++) {
					Node child = node.children.get(i);
					cs.push(child);
				}
			} else {
				for (int i = node.children.size() - 1; i >= 0; i--) {
					Node child = node.children.get(i);
					cs.push(child);
				}
			}

			if (ms.size() == 0) {
				ms = cs;
				cs = new Stack<>();
				level++;
				System.out.println();
			}
		}
	}

	public static void levelOrderzigziagAlternateTraversa(Node node) {

	}

	public static void levelOrderzigziagAlternateTraversal(Node node) {
		Stack<Node> ms = new Stack<>();
		ms.push(node);

		int level = 0;
		Stack<Node> cs = new Stack<>();

		while (ms.size() > 0) {
			node = ms.pop();
			System.out.print(node.data + " ");

			if (level % 2 == 1) {
				for (int i = 0; i < node.children.size(); i++) {
					Node child = node.children.get(i);
					cs.push(child);
				}
			} else {
				for (int i = node.children.size() - 1; i >= 0; i--) {
					Node child = node.children.get(i);
					cs.push(child);
				}
			}

			if (ms.size() == 0) {
				ms = cs;
				cs = new Stack<>();
				level++;
				System.out.println();
			}
		}
	}

	/**
	 * MIRROR
	 */

	public static void mirror(Node node) {
		for (Node child : node.children) {
			mirror(child);
		}
		Collections.reverse(node.children);
	}

	/**
	 * REMOVE LEAFS
	 * 
	 * @param args
	 **/

	public static void removeLeafs(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);
			if (child.children.size() == 0) {
				node.children.remove(child);
			}
		}

		for (Node child : node.children) {
			removeLeafs(child);
		}
	}

	/**
	 * LINEARIZE TREE *
	 **/

	public static void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);
		}

		while (node.children.size() > 1) {
			Node lastchild = node.children.remove(node.children.size() - 1);
			Node secondlastchild = node.children.get(node.children.size() - 1);

			Node stl = getTail(secondlastchild);
			stl.children.add(lastchild);
		}
	}

	public static Node getTail(Node node) {
		while (node.children.size() == 1) {
			node = node.children.get(0);
		}
		return node;
	}

	/***
	 * @param node
	 * @param data
	 * @return
	 *
	 */

	public static ArrayList nodetoroot(Node node, int data) {
		if (node.data == data) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(node.data);
			return list;
		}

		for (Node child : node.children) {
			ArrayList list = nodetoroot(child, data);
			if (list.size() > 0) {
				list.add(node.data);
				return list;
			}
		}
		return new ArrayList<>();
	}

	public static Boolean find(Node node, int num) {
		if (node.data == num) {
			return true;
		}
		for (Node child : node.children) {
			Boolean found = find(child, num);
			if (found) {
				return true;
			}
		}
		return false;
	}

	/***
	 * @param node
	 * @param data
	 * @return
	 */

	public static int lowestcommonancestor(Node node, int data1, int data2) {
		ArrayList<Integer> list1 = nodetoroot(node, data1);
		ArrayList<Integer> list2 = nodetoroot(node, data2);

		int i = list1.size() - 1;
		int j = list2.size() - 1;

		while (i >= 0 && j >= 0 && list1.get(i) == list2.get(j)) {
			i--;
			j--;
		}
		i++;
		j++;

		return list1.get(i);
	}

	public static int distancebetweennodes(Node node, int data1, int data2) {

		ArrayList<Integer> list1 = nodetoroot(node, data1);
		ArrayList<Integer> list2 = nodetoroot(node, data2);

		int i = list1.size() - 1;
		int j = list2.size() - 1;

		while (i >= 0 && j >= 0 && list1.get(i) == list2.get(j)) {
			i--;
			j--;
		}
		i++;
		j++;

		return i + j;
	}

	public static Boolean areSimilar(Node node1, Node node2) {
		if (node1.children.size() != node2.children.size()) {
			return false;
		}

		for (int i = 0; i < node1.children.size(); i++) {
			Node c1 = node1.children.get(i);
			Node c2 = node2.children.get(i);

			if (areSimilar(c1, c2) == false) {
				return false;
			}
		}
		return true;
	}

	public static Boolean isMirror(Node node1, Node node2) {
		if (node1.children.size() != node2.children.size()) {
			return false;
		}

		for (int i = 0; i < node1.children.size(); i++) {
			int j = node2.children.size() - 1 - i;
			Node c1 = node1.children.get(i);
			Node c2 = node2.children.get(j);

			if (isMirror(c1, c2) == false) {
				return false;
			}
		}
		return true;
	}

	public static Boolean isSymmetric(Node node) {
		return isMirror(node, node);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };

		int[] arr2 = { 10, 25, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };

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
		Node root2 = null;
		Stack<Node> stack2 = new Stack<>();
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] == -1) {
				stack2.pop();
			} else {
				Node t = new Node();
				t.data = arr2[i];
				if (stack2.size() > 0) {
					stack2.peek().children.add(t);
				} else {
					root2 = t;
				}
				stack2.push(t);
			}
		}
		// System.out.println(size(root));
		// System.out.println(max(root));
		// System.out.println(height(root, 0));
		// System.out.println(height2(root));
		// traversal(root);
		// levelordertraversal(root);
		// levelorderlinewisetraversal(root);
		// levelorderzigzagtraversal(root);
		// levelorderlinewiseWithNulltraversal(root);
		// levelOrderzigziagAlternateTraversal(root);
		// mirror(root);
		// removeLeafs(root);
		// linearize(root);
		// display(root);
		// levelorderzigzagtraversal(root);
		// System.out.println(find(root, 44));
		System.out.println(nodetoroot(root, 100));
		System.out.println(areSimilar(root, root2));
		System.out.println(isMirror(root, root2));
		System.out.println(isSymmetric(root));
	}

}
