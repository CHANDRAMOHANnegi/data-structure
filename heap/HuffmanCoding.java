package heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCoding {
	static HashMap<String, String> decode = new HashMap<>();
	static HashMap<String, String> encode = new HashMap<>();

	public static void main(String[] args) {
		huffman_Tree("aababcbacbbcabvdbdnmyiouynybwxwwtcxwcbabcbebbebdbebdbdb");
		System.out.println(encode);
		System.out.println(encode("abcbabacba"));
		System.out.println(decode("01111010110111101101011011"));
	}

	public static class Node implements Comparable<Node> {

		String data;
		Node left = null;
		Node right = null;

		int freq = 0;

		Node(String data, int freq, Node left, Node right) {
			this.data = data;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node o) {
			return this.freq - o.freq;
		}

	}

	public static void huffman_Tree(String str) {
		int[] freq = new int[26];
		for (int i = 0; i < str.length(); i++) {
			freq[str.charAt(i) - 'a']++;
		}
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				Node node = new Node((char) (i + 'a') + "", freq[i], null, null);
				pq.add(node);
			}
		}

		while (pq.size() != 1) {
			Node one = pq.remove();
			Node two = pq.remove();

			Node node = new Node(one.data + two.data, one.freq + two.freq, one, two);
			pq.add(node);
		}
		traverseTree(pq.remove(), "");
	}

	public static void traverseTree(Node node, String ans) {
		if (node.left == null && node.right == null) {
			decode.put(ans, node.data);
			encode.put(node.data, ans);
			return;
		}
		traverseTree(node.left, ans + "0");
		traverseTree(node.right, ans + "1");
	}

	public static String decode(String str) {
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (int i = 0; i <= str.length(); i++) {
			String possibleStr = str.substring(j, i);
			if (decode.containsKey(possibleStr)) {
				j = i;
				sb.append(decode.get(possibleStr));
			}
		}
		return sb.toString();
	}

	public static String encode(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			String s = str.charAt(i) + "";
			String res = encode.get(s);
			sb.append(res);
		}
		return sb.toString();
	}
}
