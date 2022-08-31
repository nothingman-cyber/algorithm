package algorithm;

import java.util.Stack;

public class StringMultiplication {

    public static void main(String[] args) {
        String i1 = "100000";
        String i2 = "0";
        String res = addStrings(i2, i1);
        int i = 1;
    }


    public static String addStrings(String n1, String n2) {
        int len1 = n1.length();
        int len2 = n2.length();

        int idx1 = len1 - 1;
        int idx2 = len2 - 1;

        int cmp = 0;

        Stack<Character> s = new Stack();

        while (idx1 >= -1 || idx2 >= -1) {
            if (idx1 == -1 || idx2 == -1) {
                if (idx1 == -1 && idx2 == -1) {
                    if (cmp == 1) {
                        s.push('1');
                    }
                    break;
                } else if (idx1 == -1) {
                    int z = n2.charAt(idx2--) - '0';
                    int sum = z + cmp;
                    s.push((char)(sum % 10 + '0'));
                    if (sum / 10 == 1) {
                        cmp = 1;
                    } else {
                        cmp = 0;
                    }
                } else if (idx2 == -1) {
                    int z = n1.charAt(idx1--) - '0';
                    int sum = z + cmp;
                    s.push((char)(sum % 10 + '0'));
                    if (sum / 10 == 1) {
                        cmp = 1;
                    } else {
                        cmp = 0;
                    }
                }
            } else {
                int x = n1.charAt(idx1--) - '0';
                int y = n2.charAt(idx2--) - '0';
                int sum = x + y + cmp;
                s.push((char)(sum % 10 + '0'));
                if (sum / 10 == 1) {
                    cmp = 1;
                } else {
                    cmp = 0;
                }
            }
        }

        String res = "";
        while(!s.isEmpty()) {
            res = res + s.pop();
        }
        return res;
    }

}
