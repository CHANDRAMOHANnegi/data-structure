public class Fib {

    public static int fibRec(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static int fibMem(int n, int[] strg) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (strg[n] != 0) {
            return strg[n];
        }
        int fnm1 = fibMem(n - 1, strg);
        int fnm2 = fibMem(n - 2, strg);

        int fn = fnm1 + fnm2;
        strg[n] = fn;

        return fn;
    }

    public static int fibDp(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        int i = 2;
        while (i <= n) {
            dp[i] = dp[i - 1] + dp[i - 2];
            i++;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(fibRec(8));
        System.out.println(fibDp(8));
        System.out.println(fibMem(n, new int[9]));
    }

}
