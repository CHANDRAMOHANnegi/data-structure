package recursion_on_the_way_up;

import java.util.ArrayList;

public class MazePath {

	public static int counter = 0;

	public static void main(String[] args) {
//		System.out.println(getMazePath(0, 0, 2, 2));
//		System.out.println(getMazePathMultipleJumps(0, 0, 2, 2));
		printMazePathMultipleJumps(0, 0, 2, 2, "");
//		printMazePath(0, 0, 2, 2, "");
	}

	private static ArrayList<String> getMazePath(int sr, int sc, int dr, int dc) {
//		System.out.println(counter++);
		if (sr == dr && sc == dc) {
			ArrayList<String> ans = new ArrayList<>();
			ans.add("");
			return ans;
		}

		ArrayList<String> hr = new ArrayList<>();

		if (sc < dc)
			hr = getMazePath(sr, sc + 1, dr, dc);

		ArrayList<String> vr = new ArrayList<>();
		if (sr < dr)
			vr = getMazePath(sr + 1, sc, dr, dc);

		ArrayList<String> fin = new ArrayList<>();

		for (String str : vr) {
			fin.add(str + "v");
		}
		for (String str : hr) {
			fin.add(str + "h");
		}

		return fin;
	}

	private static void printMazePath(int sr, int sc, int dr, int dc, String path) {
		if (sr == dr && sc == dc) {
			System.out.println(path);
		}

		if (sc < dc)
			printMazePath(sr, sc + 1, dr, dc, path + "h");

		if (sr < dr)
			printMazePath(sr + 1, sc, dr, dc, path + "v");

	}

	private static ArrayList<String> getMazePathMultipleJumps(int sr, int sc, int dr, int dc) {

		if (sr == dr && sc == dc) {
			ArrayList<String> ans = new ArrayList<>();
			ans.add("");
			return ans;
		}

		ArrayList<String> fin = new ArrayList<>();
		ArrayList<String> vr = new ArrayList<>();
		ArrayList<String> hr = new ArrayList<>();

		for (int jump = 1; jump <= (dr - sr); jump++) {
			vr = getMazePathMultipleJumps(sr + jump, sc, dr, dc);
			for (String str : vr) {
				fin.add(str + jump + "v");
			}
		}

		for (int jump = 1; jump <= (dc - sc); jump++) {
			hr = getMazePathMultipleJumps(sr, sc + jump, dr, dc);
			for (String str : hr) {
				fin.add(str + jump + "h");
			}
		}

		return fin;
	}

	

	private static void printMazePathMultipleJumps(int sr, int sc, int dr, int dc, String path) {
		if (sr == dr && sc == dc) {
			System.out.println(path);
		}

		
		for (int jump = 1; jump <= (dc - sc); jump++) {
			printMazePathMultipleJumps(sr, sc + jump, dr, dc, path +jump+ "h");
		}
		
		for (int jump = 1; jump <= (dr - sr); jump++) {
			printMazePathMultipleJumps(sr + jump, sc, dr, dc, path +jump+ "v");
		}
	}

	
}
