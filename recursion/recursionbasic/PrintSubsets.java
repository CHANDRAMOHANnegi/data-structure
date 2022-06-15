import java.util.ArrayList;

public class PrintSubsets {

    public static void printSubset(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String remString = str.substring(1);

        printSubset(remString, ans + "" + ch);
        printSubset(remString, ans);

    }

    public static ArrayList<ArrayList<Integer>> printSubsetArr(int[] arr, int n, ArrayList<Integer> asf,
            ArrayList<ArrayList<Integer>> list) {

        if (n == 0) {
            System.out.println(asf);
            list.add(asf);
        }

        printSubsetArr(arr, n - 1, asf.add(arr[0]), list);
        printSubsetArr(arr, n - 1, asf, list);
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 3, 2, 4 };

        // printSubset("aba", "");
        printSubsetArr(arr, arr.length - 1, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>());
    }

}
