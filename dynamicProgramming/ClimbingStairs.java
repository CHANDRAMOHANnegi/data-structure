public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 6;
        System.out.println(stairCountTab(new int[n + 1], n));
    }

    public static int stairCountTab(int[] tab, int n) {
        tab[0] = 1;
        tab[1] = 1;
        tab[2] = 2;

        for (int i = 3; i < n; i++) {
            tab[i] = tab[i - 1] + tab[i - 2] + tab[i - 3];
        }
        return tab[n];
    }

    public static int stairCountWithJumpsTab() {
        int n = 6;
        int tab[] = new int[n];
        int[] arr = new int[] { 1, 2, 3, 4 };

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j < arr.length; j++) {
                if (i - j > 0) {
                    tab[i] += tab[i - j];
                }
            }
        }
        return tab[n];
    }

}
