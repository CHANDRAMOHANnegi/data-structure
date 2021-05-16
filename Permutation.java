
public class Permutation {
	static int count = 0;

	public static void permutation(boolean[] boxes, int tq, int qpsf, String per) {

		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + per);
			return;
		}

		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				permutation(boxes, tq, qpsf + 1, per + " b" + i + "q" + (qpsf + 1));
				boxes[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		permutation(new boolean[3], 2, 0, "");
	}

}
