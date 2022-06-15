package graphbasic;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphBasic {
	public Scanner sc = new Scanner(System.in);

	static ArrayList<Edge>[] graph = new ArrayList[7];

	static class Edge {
		int v;
		int w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		public Edge() {
		}
	}

	public static void connect() {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		addEdge(0, 3, 10);
		addEdge(0, 1, 10);
		addEdge(1, 2, 10);
		addEdge(2, 3, 40);
		addEdge(3, 4, 2);
		addEdge(4, 5, 2);
		addEdge(4, 6, 3);
		addEdge(5, 6, 8);

	}

	public static void addEdge(int u, int v, int w) {
		if (v < 0 || u < 0 || u > graph.length || v > graph.length)
			return;

		graph[u].add(new Edge(v, w));
		graph[v].add(new Edge(u, w));
	}

	public static void display() {
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + " => ");
			for (Edge edge : graph[i]) {
				System.out.print(" (" + edge.v + " " + edge.w + " ),");
			}
			System.out.println();
		}
	}

	public static void removeE(int u, int v) {
		int j = -1;
		int k = -1;

		for (int i = 0; i < graph[u].size(); i++) {
			if (graph[u].get(i).v == v) {
				j = i;
				break;
			}
		}

		for (int i = 0; i < graph[v].size(); i++) {
			if (graph[v].get(i).v == u) {
				k = i;
				break;
			}
		}
		graph[u].remove(j);
		graph[v].remove(k);
	}

	public static void removeVtx(int u) {
		for (int i = graph[u].size() - 1; i >= 0; i--) {
			removeE(graph[u].get(i).v, u);
		}
	}

	public static void haspath(int src, int des, boolean[] visited, String path) {

		if (src == des) {
			System.out.println(path);
			return;
		}
		if (visited[src]) {
			return;
		}
		visited[src] = true;
		for (Edge edge : graph[src]) {
			haspath(edge.v, des, visited, path + " " + edge.v);
		}
		visited[src] = false;

	}

	public static void solve() {
		connect();
//		removeVtx(3);
//		display();
		haspath(0, 6, new boolean[7], "0");
	}

	public static void main(String[] args) {
		solve();
	}

}
