
public class Combination {
	static int counter = 0;

	public static void combination(boolean boxes[], int tq, int qpsf, String str,int lqpb) {

		if (qpsf == tq) {
			counter++;

//			System.out.println(counter + ". " + str);
			return;
		}

		for (int i = lqpb+1; i < boxes.length; i++) {
			if (boxes[i]==false) {
				boxes[i] = true;
				combination(boxes, tq, qpsf + 1, str + "b" + i + "q" + (qpsf + 1),i);
				boxes[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		combination(new boolean[3], 2, 0, "",-1);
	}
}
