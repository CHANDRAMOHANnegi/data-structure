import java.util.*;
import java.io.*;

public class DuplicateBracket {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                if (stack.peek() == '(') {
                    System.out.println(true);
                    scn.close();
                    return;
                }
                while (stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        System.out.println(false);
        scn.close();
    }
}
