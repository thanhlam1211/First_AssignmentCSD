/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Manager;
import Entity.Validate;
import static GUI.ProductGUI.displayData;
import Intermediaries.CustomerInter;
import java.io.IOException;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CustomerGUI {

    Manager manager = new Manager();
    static CustomerInter customerInter = new CustomerInter();

    public static void menu() throws Exception {
        System.out.println("2.1. Load data from file");
        System.out.println("2.2. Input & add to the end");
        System.out.println("2.3. Display data");
        System.out.println("2.4. Save customer list to file");
        System.out.println("2.5. Search by ccode");
        System.out.println("2.6. Delete by ccode");
        System.out.println("2.7. Exit");
        int option = Validate.checkInputIntLimit(1, 7);
        switch (option) {
            case 1: {
                loadCustomerFile();
                System.err.println("Load success!");
                break;
            }
            case 2: {
                addCustomer();
                break;
            }
            case 3: {
                displayCustomerData();
                break;
            }
            case 4: {
                saveCustomerToFile();
                System.err.println("Save success!");
                break;
            }
            case 5: {
                searchByCCode();
                break;
            }
            case 6: {
                deleteCustomerByCode();
                System.err.println("Delete success!");
                break;
            }
            case 7: {
                return;
            }
        }
    }

    public static void loadCustomerFile() throws Exception {
        customerInter.loadCustomerFile();
    }

    public static void addCustomer() {
        System.out.print("Enter ccode: ");
        String ccode = Validate.checkInputString();
        System.out.print("Enter cus_name: ");
        String pro_name = Validate.checkInputString();
        System.out.print("Enter phone: ");
        String phone = Validate.checInputPhone();
        if(CustomerInter.checkCustomerExist(ccode)) {
            System.err.println("Ccode has aready exist!");
        }else {
            customerInter.addCustomer(ccode, pro_name, phone);
        }
    }

    public static void saveCustomerToFile() throws IOException {
        customerInter.saveCustomerToFile();
    }

    public static void searchByCCode() {
        System.out.print("Enter ccode you want to search: ");
        String ccode = Validate.checkInputString();
        customerInter.searchCustomerByCode(ccode);
    }

    public static void displayCustomerData() {
        CustomerInter.displayData();
    }

    public static void deleteCustomerByCode() {
        System.out.print("Enter ccode you want to delete: ");
        String ccode = Validate.checkInputString();
        CustomerInter.deleteCustomerByCode(ccode);
        Manager.deleteCustomer(ccode);
    }

}
