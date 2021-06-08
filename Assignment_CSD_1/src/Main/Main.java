/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entity.Validate;
import GUI.CustomerGUI;
import GUI.OrderingGUI;
import GUI.ProductGUI;

/**
 *
 * @author Thanh Lam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        while (true) {
            System.out.println("Lam dep trai nhat");
            System.out.println("1. Product list");
            System.out.println("2. Customer list");
            System.out.println("3. Order list");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            System.out.println("lai con cu to");
            System.out.println("đây là commit lần 3");
            int choice = Validate.checkInputIntLimit(1, 3);
            switch (choice) {
                case 1: {
                    ProductGUI.menu();
                    break;
                }
                case 2: {
                    CustomerGUI.menu();
                    break;
                }
                case 3: {
                    OrderingGUI.menu();
                    break;
                }
                case 4 : {
                    return;
                }
            }

        }

    }
}
