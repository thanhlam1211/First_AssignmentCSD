/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Information.Customer;
import Information.Ordering;
import Information.Product;
import Node.MyList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

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
        currentDir = currentDir + "\\src\\Information\\DataFile.txt";
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
        System.err.println("Add success");
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
                System.err.println("Delete successful");
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
    public static boolean checkInputIndex(int index){
        return index <= productList.size();
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
        System.out.println("Add success!");
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
}
