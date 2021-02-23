/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Manager;
import Entity.Validate;
import Intermediaries.OrderingInter;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class OrderingGUI {

    static OrderingInter orderingInter = new OrderingInter();

    public static void menu() {
        System.out.println("3.1. Input data");
        System.out.println("3.2. Display data with total value");
        System.out.println("3.3. Sort by pcode + ccode");
        System.out.println("3.4. Exit");
        System.out.print("Enter your choice: ");
        int option = Validate.checkInputIntLimit(1, 4);
        switch (option) {
            case 1: {
                inputData();
                break;
            }
            case 2: {
                displayData();
                break;
            }
            case 3: {
                sortByBothCode();
                break;
            }
            case 4: {
                return;
            }
        }
    }

    public static void inputData() {
        System.out.print("Enter pcode: ");
        String pcode = Validate.checkInputString();
        String pcode_checked = orderingInter.checkInputPcode(pcode);
        if (pcode_checked == null) {
            System.out.println("Pcode not found in Customer list");
            return;
        }
        System.out.print("Enter ccode: ");
        String ccode = Validate.checkInputString();
        String ccode_checked = orderingInter.checkInputCcode(ccode);
        if (ccode_checked == null) {
            System.out.println("Ccode not found in Customer list");
            return;
        }
        System.out.print("Enter quantity: ");
        int quantity = Validate.checkInputInt();
        orderingInter.add(pcode_checked, ccode_checked, quantity);
    }

    public static void displayData() {
        orderingInter.display();
    }

    private static void sortByBothCode() {
        orderingInter.sortByBothCode();
    }
}
