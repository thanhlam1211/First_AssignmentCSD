/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import static Entity.Manager.productList;
import Information.Customer;
import Information.Ordering;
import Information.Product;
import Intermediaries.ProductInter;
import Node.MyList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Thanh Lam
 */
public class Manager {

    public static MyList<Product> productList = new MyList<Product>();
    public static MyList<Customer> customerList = new MyList<Customer>();
    public static MyList<Ordering> orderingList = new MyList<Ordering>();

    public static MyList<Product> getProductList() {
        return productList;
    }

    public static void setProductList(MyList<Product> productList) {
        Manager.productList = productList;
    }

    public static MyList<Customer> getCustomerList() {
        return customerList;
    }

    public static void setCustomerList(MyList<Customer> customerList) {
        Manager.customerList = customerList;
    }

    public static MyList<Ordering> getOrderingList() {
        return orderingList;
    }

    public static void setOrderingList(MyList<Ordering> orderingList) {
        Manager.orderingList = orderingList;
    }

    //function to load product from file
    public static void loadProductFormFile() throws Exception {
        String currentDir = System.getProperty("user.dir");
        currentDir = currentDir + "\\src\\Information\\ProductFile.txt";
        FileReader fr = new FileReader(currentDir);
        BufferedReader br = new BufferedReader(fr);
        String[] arr;
        String s, pcode, pro_name;
        int quantity, saled;
        double price;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 3) {
                break;
            }
            arr = s.split("[|]");
            pcode = arr[0].trim();
            pro_name = arr[1].trim();
            quantity = Integer.parseInt(arr[2].trim());
            saled = Integer.parseInt(arr[3].trim());
            price = Double.parseDouble(arr[4].trim());
            productList.addLast(new Product(pcode, pro_name, quantity, saled, price));
        }
        fr.close();
        br.close();
    }

    //function to load customer form file
    public static void loadCustomerFormFile() throws Exception {
        String currentDir = System.getProperty("user.dir");
        currentDir = currentDir + "\\src\\Information\\Customer.txt";
        FileReader fr = new FileReader(currentDir);
        BufferedReader br = new BufferedReader(fr);
        String[] arr;
        String s, ccode, cus_name, phone;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 3) {
                break;
            }
            arr = s.split("[|]");
            ccode = arr[0].trim();
            cus_name = arr[1].trim();
            phone = arr[2].trim();
            customerList.addLast(new Customer(ccode, cus_name, phone));
        }
        fr.close();
        br.close();
    }

    //functions to save product to file
    public static void saveProductFile() throws IOException {
        String currentDir = System.getProperty("user.dir");
        currentDir = currentDir + "\\src\\Information\\ProductFile.txt";
        FileWriter fw = new FileWriter(currentDir);
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < productList.size(); i++) {
            pw.printf("%5s | %4s  | %3d  | %4d   | %8.2f\r\n", productList.get(i).pcode,
                    productList.get(i).pro_name, productList.get(i).quantity,
                    productList.get(i).saled, productList.get(i).price);
        }
        pw.close();
        fw.close();
    }

    //function to save customer to file
    public static void saveCustomerFile() throws IOException {
        String currentDir = System.getProperty("user.dir");
        currentDir = currentDir + "\\src\\Information\\Customer.txt";
        FileWriter fw = new FileWriter(currentDir);
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < customerList.size(); i++) {
            pw.printf("%5s | %5s | %4s\r\n", customerList.get(i).ccode, customerList.get(i).cus_name,
                    customerList.get(i).phone);
        }
        pw.close();
        fw.close();
    }

    public static Product getProduct(String pcode) {
        for (int i = 0; i < productList.size(); i++) {
            if ((productList.get(i)).getPcode().equals(pcode)) {
                return productList.get(i);
            }
        }
        return null;
    }

    public static boolean checkExistProduct(String pcode) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPcode().equals(pcode)) {
                return true;
            }
        }
        return false;
    }

    public static void addProductLast(Product product) {
        productList.addLast(product);
    }

    public static void addProductIndex(Product product, int index) {
        if (index > productList.size()) {
            System.err.println("Please try again");
        } else {
            productList.addIndex(product, index);
            System.err.println("Add success");
        }
    }

    public static int findProductIndex(String pcode) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPcode().equals(pcode)) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteProductByIndex(int index) {
        productList.delIndex(index);
    }

    public static void deleteProductByCode(String code) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPcode().equals(code)) {
                productList.delIndex(i);
                System.out.println("Delete successful");
                return;
            }
        }

    }
//    public void deleteProductPosition(int index) {
//
//    }

    public static void sortProductByCode() {
        for (int i = 0; i < productList.size() - 1; i++) {
            for (int j = i + 1; j < productList.size(); j++) {
                if (productList.get(i).getPcode().compareTo(productList.get(j).getPcode()) > 0) {
                    Product temp = productList.get(i);
                    productList.set(i, productList.get(j));
                    productList.set(j, temp);
                }
            }

        }
        System.out.println("Sort success");
    }

    public static boolean checkInputIndex(int index) {
        return index < productList.size();
    }

    public static void addCustomer(Customer customer) {
        customerList.addLast(customer);
        System.out.println("Add success!");
    }

    public static boolean checkCustomerExist(String code) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCcode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public static Customer getCustomer(String Ccode) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCcode().equals(Ccode)) {
                return customerList.get(i);
            }
        }
        return null;
    }

    public static void deleteCustomer(String code) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCcode().equals(code)) {
                customerList.delIndex(i);
                System.out.println("Delete success!");
                return;
            }
        }
        System.out.println("Customer not found!");
    }

    public static void addOrder(Ordering ordering) {
        orderingList.addLast(ordering);
    }

    public static void updateOrder(String pcode) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPcode().equals(pcode)) {
                Product curentProduct = productList.get(i);
                productList.set(i, new Product(curentProduct.getPcode(), curentProduct.getPro_name(),
                        curentProduct.getQuantity(), curentProduct.getSaled() + 1, curentProduct.getPrice()));
            }
        }
    }

    public static int checkExistOrdering(String pcode, String ccode) {
        for (int i = 0; i < orderingList.size(); i++) {
            Ordering currentOrder = orderingList.get(i);
            if (currentOrder.getPcode().equals(pcode) && currentOrder.getCcode().equals(ccode)) {
                return currentOrder.getQuantity();
            }
        }
        return -1;
    }

    public static void sortOrdering() {
        for (int i = 0; i < orderingList.size() - 1; i++) {
            Ordering currentOrder1 = orderingList.get(i);
            for (int j = i + 1; j < orderingList.size(); j++) {
                Ordering currentOrder2 = orderingList.get(i), temp;
                if (currentOrder1.getPcode().compareTo(currentOrder2.getPcode()) > 0) {
                    temp = currentOrder1;
                    orderingList.set(i, currentOrder2);
                    orderingList.set(j, temp);
                } else if (currentOrder1.getPcode().compareTo(currentOrder2.getPcode()) == 0
                        && currentOrder1.getCcode().compareTo(currentOrder2.getCcode()) > 0) {
                    temp = currentOrder1;
                    orderingList.set(i, currentOrder2);
                    orderingList.set(j, temp);
                }
            }
        }
    }

    public static void addOrdering(String pcode, String ccode, int quantity) {
        Product product = Manager.getProduct(pcode);
        Ordering ordering;

        if (Manager.checkExistProduct(pcode) && Manager.checkCustomerExist(ccode)) {
            if (Manager.checkExistOrdering(pcode, ccode) == -1) {
                if (product.getQuantity() == product.getSaled()) {
                    System.out.println("Product is exhausted!");
                } else {
                    ordering = new Ordering(pcode, ccode, quantity);
                    Manager.updateOrder(pcode);
                    Manager.addOrder(ordering);
                    System.out.println("Add success!");
                    return;
                }
                if (product.getSaled() < product.getQuantity()
                        && quantity <= (product.getQuantity() - product.getSaled())) {
                    ordering = new Ordering(pcode, ccode, quantity);
                    Manager.updateOrder(pcode);
                    Manager.addOrder(ordering);
                    System.out.println("Add success!");
                } else {
                    System.out.println("Invalid quantity! Try again.");
                }
            }
        } else {
            System.out.println("Product or Customer not found! Try again");
        }
    }

    public static String checkInputPcode(String pcode) {
        if (checkExistProduct(pcode)) {
            return pcode;
        }
        for (int i = 0; i < productList.size(); i++) {
            Product currentProduct = productList.get(i);
            if (pcode.length() == 1 || pcode.length() == 2) {
                continue;
            }
            if (!currentProduct.getPcode().equalsIgnoreCase(pcode)) {
                return null;
            }
        }
        System.out.printf("%5s|%11s|%10s|%8s|%8s|%8s\n", "pcode", "pro_name", "quantity", "saled", "price", "value");
        System.out.println("=======================================================");
        for (int i = 0; i < productList.size(); i++) {
            Product currentProduct = productList.get(i);
            if (currentProduct.getPcode().contains(pcode)) {
                System.out.printf("%5s|%11s|%10s|%8s|%8s|%8s\n", currentProduct.getPcode().toUpperCase(), currentProduct.getPro_name(),
                        currentProduct.getQuantity(), currentProduct.getSaled(), currentProduct.getPrice(),
                        String.format("%.1f", currentProduct.getPrice() * currentProduct.getSaled()));
            }
        }
        System.out.print("Enter pcode you want to continue: ");
        String pcode_input = Validate.checkInputString();
        if (checkExistProduct(pcode_input)) {
            return pcode_input;
        }

        return null;
    }

    public static String checkInputCcode(String ccode) {
        if (checkCustomerExist(ccode)) {
            return ccode;
        }
        for (int i = 0; i < customerList.size(); i++) {
            Customer currentCustomer = customerList.get(i);
            if (ccode.length() == 1 || ccode.length() == 2) {
                continue;
            }
            if (!currentCustomer.getCcode().equalsIgnoreCase(ccode)) {
                return null;
            }
        }
        System.out.printf("%5s|%8s|%7s\n", "ccode", "cus_name", "phone");
        System.out.println("=========================");
        for (int i = 0; i < customerList.size(); i++) {
            Customer currentCustomer = customerList.get(i);
            if (currentCustomer.getCcode().contains(ccode)) {
                System.out.printf("%5s|%8s|%7s\n", currentCustomer.getCcode().toUpperCase(),
                        currentCustomer.getCus_name(), currentCustomer.getPhone());
            }
        }

        System.out.print("Enter ccode you want to continue: ");
        String ccode_input = Validate.checkInputString();
        if (checkCustomerExist(ccode_input)) {
            return ccode_input;
        }

        return null;
    }
}
