
public class PrintEncoding {

    public static void main(String[] args) {

        printEncoding("655196", "");
    }

    private static void printEncoding(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        } else if (str.length() == 1) {
            String ch0 = str;

            if (ch0.equals("0")) {
                return;
            }

            int numForCh0 = Integer.parseInt(ch0);
            String alphabetForCh0 = (char) ('a' + numForCh0 - 1) + "";
            String roq0 = "";
            printEncoding(roq0, asf + alphabetForCh0);
        } else {
            String ch0 = str.substring(0, 1);
            if (ch0.equals("0")) {
                return;
            }

            int numForCh0 = Integer.parseInt(ch0);
            String alphabetForCh0 = (char) ('a' + numForCh0 - 1) + "";
            String roq0 = str.substring(1);
            printEncoding(roq0, asf + alphabetForCh0);

            // 2 numbers ka khel
            String ch01 = str.substring(0, 2);
            int numForCh01 = Integer.parseInt(ch01);
            if (numForCh01 <= 26) {
                String alphabetForCh01 = (char) ('a' + numForCh01 - 1) + "";
                String roq01 = str.substring(2);
                printEncoding(roq01, asf + alphabetForCh01);

            }
        }
    }

}
