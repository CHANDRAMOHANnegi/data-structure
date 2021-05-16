package recursionResources;

public class Combination {

	static int counter = 0;

	public static void combination(boolean[] boxes, int tq, int qpsf, String psf, int lqpb) {

		if (qpsf == tq) {
			counter++;
			System.out.println(counter + ". " + psf);
			return;
		}

		for (int box = lqpb + 1; box < boxes.length; box++) {
			if (boxes[box] == false) {
				boxes[box] = true;
				combination(boxes, tq, qpsf + 1, psf + " b" + box + "q" + (qpsf + 1), box);
				boxes[box] = false;
			}
		}
	}

	public static void coinExchangecombination(int[] denoms, int amt, int lpi, String psf) {

		if (amt == 0) {
			System.out.println(psf);
			return;
		}

		for (int ins = lpi; ins < denoms.length; ins++) {
			int newamt = amt - denoms[ins];
			if (newamt >= 0)
				coinExchangecombination(denoms, newamt, ins, psf + denoms[ins]);
		}
	}

	public static void main(String[] args) {
		boolean[] boxes = new boolean[4];
		combination(boxes, 2, 0, "", -1);
//		coinExchangecombination(new int[] { 2, 3, 5, 6 }, 10, 0, "");
	}

}
