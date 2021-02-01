/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Scanner;

/**
 *
 * @author Thanh Lam
 */
public class Validate {

    public static final Scanner sc = new Scanner(System.in);
    //check user input number limit

    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Can not be empty");
                System.out.println("Please enter again!");
            } else {
                return result;
            }
        }
    }

    //check input phone
    public static String checInputPhone() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Can not be empty");
                System.out.println("Please enter again!");
            } else if (result.contains("[a-zA-Z]+")) {
                System.err.println("Phone can only contain digits!");
                System.out.println("Try again");
            } else {
                return result;
            }
        }
    }

    //check input int
    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Please enter int number!");
                System.out.println("Enter again");
            }
        }
    }
    //check user input double

    public static double checkInputDouble() {
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }

        }
    }

    public static boolean checkInputSaledQuantity(int quantity, int saled) {
        return quantity > saled;
    }


}
