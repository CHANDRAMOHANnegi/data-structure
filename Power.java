public class Power {

    public static int power1(int x, int n) { // O(n)
        if (n == 0) {
            return 1;
        }

        int pow = power1(x, n - 1);
        int newPow = pow * x;

        return newPow;
    }

    public static int power2(int x, int n) {// O(logn)
        if (n == 0) {
            return 1;
        }

        int pow = power2(x, n / 2);
        int newPow = pow * pow;

        if (n % 2 == 1) {
            newPow *= x;
        }
        return newPow;
    }

    public static void main(String[] args) {
        System.out.println(power2(2, 5));
    }

}
