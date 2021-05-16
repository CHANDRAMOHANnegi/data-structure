package recursionResources;

public class Permutation {
	
static int counter=0;

	public static void permutation(boolean[] boxes, int tq, int qpsf, String psf) {

		if (qpsf == tq) {
			counter++;
			System.out.println(counter+". "+psf);
			return;
		}

		for (int box = 0; box < boxes.length; box++) {
			if (boxes[box] == false) {
				boxes[box] = true;
				permutation(boxes, tq, qpsf + 1, psf + " b" + box + "q" + (qpsf + 1));
				boxes[box] = false;
			}
		}
	}

	public static void coinExchangepermutation(int[] denoms, int amt, int lpi, String psf) {

		if (amt == 0) {
			counter++;
			System.out.println(counter+". "+psf);
			return;
		}

		for (int ins = 0; ins < denoms.length; ins++) {
			int newamt = amt - denoms[ins];
			if (newamt >= 0)
				coinExchangepermutation(denoms, newamt, ins, psf + denoms[ins]);
		}
	}

	public static void main(String[] args) {
		boolean[] boxes = new boolean[3];
		permutation(boxes, 2, 0, "");
//		coinExchangepermutation(new int[] { 2, 3, 5, 6 }, 10, 0, "");
	}
}
