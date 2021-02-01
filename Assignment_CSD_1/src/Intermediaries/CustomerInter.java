/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intermediaries;

import Entity.Manager;
import Entity.Validate;
import Information.Customer;
import Information.Product;
import Node.MyList;
import java.io.IOException;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CustomerInter {

    public CustomerInter() {
    }

    public void loadCustomerFile() throws Exception {
        Manager.loadCustomerFormFile();
    }

    public void saveCustomerToFile() throws IOException {
        Manager.saveCustomerFile();
    }

    public void searchCustomerByCode(String ccode) {
        Customer customer = Manager.getCustomer(ccode);
        if (customer == null) {
            System.err.println("Ccode not exist!");
            return;
        }
        customer.printCustomer();
    }

    public static void displayData() {
        MyList<Customer> CustomerList = Manager.getCustomerList();
        if (CustomerList.isEmpty()) {
            System.err.println("Empty list!");
            return;
        }
        System.out.printf("%5s|%8s|%7s\n", "ccode", "cus_name", "phone");
        System.out.println("=======================================================");
        for (int i = 0; i < CustomerList.size(); i++) {
            Customer currentCustomer = CustomerList.get(i);
            System.out.printf("%5s|%8s|%7s\n", currentCustomer.getCcode(), currentCustomer.getCus_name(), currentCustomer.getPhone());
        }
    }
    public static void deleteCustomerByCode(String ccode) {
        Manager.deleteCustomer(ccode);
    }
    public static boolean checkCustomerExist(String ccode){
        return Manager.checkCustomerExist(ccode);
    }

    public void addCustomer(String ccode, String pro_name, String phone) {
        Customer customer = new Customer(ccode, pro_name, phone);
        Manager.addCustomer(customer);
    }
}
