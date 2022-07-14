public class PrimeEratosthenes {

    public static void main(String[] args) {
        eratosthenes(30);
    }

    public static void eratosthenes(int n) {

        boolean arr[] = new boolean[n + 1];

        for (int i = 2; i * i < arr.length; i++) {
            if (arr[i] == false) {
                for (int j = i; i * j < arr.length; j++) {
                    arr[i * j] = true;
                }
            }
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i]==false) {
                System.out.println(i);
            }
        }

    }

}


/// nlog logn