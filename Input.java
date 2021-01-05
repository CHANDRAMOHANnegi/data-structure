import java.util.*;
import java.lang.*;
import java.io.*;

/* 
Name of the class has to be "Main"
only if the class is public.
*/

class Codechef {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();// no of Setters
            int k = sc.nextInt();// no of problems in contest
            int d = sc.nextInt();// no of days

            int totalProblems = 0;

            for (int i = 0; i < n; i++) {
                totalProblems += sc.nextInt();
            }

            int noOfContest = totalProblems / k;

            if (noOfContest < d) {
                System.out.println(noOfContest);
            } else {
                System.out.println(d);
            }
        }
        sc.close();
    }
}