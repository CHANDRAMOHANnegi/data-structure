
public class TOB {

    public static void tob(int noOfDisks, String s, String e, String h) {

        if (noOfDisks == 0)
            return;

        tob(noOfDisks - 1, s, h, e);

        System.out.println("move " + noOfDisks + "th from " + s + " " + e);

        tob(noOfDisks - 1, h, e, s);

    }

    public static void main(String[] args) {

        int noOfDisks = 3;

        tob(noOfDisks, "s", "e", "h");

    }

}
