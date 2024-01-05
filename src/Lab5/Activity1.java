package Lab5;

import java.util.Scanner;

public class Activity1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            String hexString = input.nextLine();
            System.out.println(hexString + ": " + hex2Dec(hexString));
        } catch (NumberFormatException e) {
            System.out.println("Not a hex number");
        }

    }

    public static int hex2Dec(String hexString) throws NumberFormatException {
    int decimalValue = 0;
    char ch = ' ';
        for (int i = 0; i < hexString.length(); i++) {
            ch = hexString.charAt(i);
            if (ch >= 'a' && ch <= 'f') {
                ch = (char) (10 + ch - 'a');
            } else if (ch >= 'A' && ch <= 'F') {
                ch = (char) (10 + ch - 'A');
            } else if (ch >= '0' && ch <= '9') {
                ch = (char) (ch - '0');
            }   else {
                throw new NumberFormatException();
            }

            decimalValue = decimalValue * 16 + ch;
        }
        return decimalValue;    }

}
