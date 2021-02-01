/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intermediaries;

import Entity.Manager;
import Information.Product;
import Node.MyList;
import java.io.IOException;

/**
 *
 */
public class ProductInter {

    public static void loadFileProduct() throws Exception {
        Manager.loadProductFormFile();
    }

    public static void saveFileProduct() throws Exception {
        Manager.saveProductFile();
    }

    public static boolean checkProductExist(String code) {
        return Manager.checkCustomerExist(code);
    }

    public static void addProduct(String pcode, String pro_name, int quantity, int saled, double price) {
        Product product = new Product(pcode, pro_name, quantity, saled, price);
        Manager.addProductLast(product);
    }

    public static void addProductIndex(String pcode, String pro_name, int quantity, int saled, double price, int index) {
        Product product = new Product(pcode, pro_name, quantity, saled, price);
        Manager.addProductIndex(product, index);
    }

    public static void displayData() {
        MyList<Product> prodductList = Manager.getProductList();
        if (prodductList.isEmpty()) {
            System.err.println("Empty list!");
            return;
        }
        System.out.printf("%5s|%11s|%10s|%8s|%8s|%8s\n", "pcode", "pro_name", "quantity", "saled", "price","value");
        System.out.println("=======================================================");
        for (int i = 0; i < prodductList.size(); i++) {
            Product currentProduct = prodductList.get(i);
            System.out.printf("%5s|%11s|%10s|%8s|%8s|%8s\n", currentProduct.getPcode(), currentProduct.getPro_name(),
                    currentProduct.getQuantity(), currentProduct.getSaled(), currentProduct.getPrice(),
                    currentProduct.getQuantity() * currentProduct.getSaled());
        }
    }

    public static void saveProductToFile() throws IOException {
        Manager.saveProductFile();
    }

    public static void getProductByCode(String pcode) {
        Product product = Manager.getProduct(pcode);
        if (product == null) {
            System.err.println("Pcode not exist!");
            return;
        }
        product.printProduct();
    }

    public static void deleteProduct(String pcode) {
        Manager.deleteProductByCode(pcode);
    }

    public void deleteProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void sortProductByCode() {
        Manager.sortProductByCode();
    }

    public void deleteBefore(String pcode) {
        if(Manager.checkExistProduct(pcode)) {
            int index = Manager.findProductIndex(pcode);
            if(index == 0) {
                System.err.println("Can not delete because node having pcode: " + pcode + " is the first node!");
                return;
            }
            Manager.deleteProductByIndex(index - 1);
            System.err.println("Delete Success!");
            return;
        }
        System.err.println("Product doesn't exist!");
    }
    public boolean checkInputIndex(int index){
        return Manager.checkInputIndex(index);
    }
}
