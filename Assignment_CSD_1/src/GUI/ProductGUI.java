/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Manager;
import Entity.Validate;
import Intermediaries.ProductInter;
import java.io.IOException;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ProductGUI {

    Manager manager = new Manager();
    static ProductInter productInter = new ProductInter();

    public static void menu() throws Exception {
        System.out.println("1.1. Load data from file");
        System.out.println("1.2. Input & add to the end");
        System.out.println("1.3. Display data");
        System.out.println("1.4. Save product list to file");
        System.out.println("1.5. Search by pcode");
        System.out.println("1.6. Delete by pcode");
        System.out.println("1.7. Sort by pcode");
        System.out.println("1.8. Add after position  k");
        System.out.println("1.9. Delete the node after the node having code = xCode");
        System.out.println("1.10. Exit");
        System.out.print("Enter your choice: ");
        int option = Validate.checkInputIntLimit(1, 10);
        switch (option) {
            case 1: {
                loadProductFile();
                break;
            }
            case 2: {
                addProduct();

                break;
            }
            case 3: {
                displayData();
                break;
            }
            case 4: {
                saveProductToFile();
                break;
            }
            case 5: {
                searchProductByCode();
                break;
            }
            case 6: {
                deleteProduct();

                break;
            }
            case 7: {
                sortProductByCode();
                break;
            }
            case 8: {
                addProductIndex();

                break;
            }
            case 9: {
                deleteBefore();
                break;
            }
            case 10: {
                return;
            }
        }
    }

    public static void loadProductFile() throws Exception {
        ProductInter.loadFileProduct();
        System.out.println("Load data success!");
    }

    private static void addProduct() {
        System.out.print("Enter pcode: ");
        String pcode = Validate.checkInputString();
        System.out.print("Enter pro_name: ");
        String pro_name = Validate.checkInputString();
        System.out.print("Enter quantity: ");
        int quantity = Validate.checkInputInt();
        System.out.print("Enter saled: ");
        int saled = Validate.checkInputInt();
        if (!Validate.checkInputSaledQuantity(quantity, saled)) {
            System.err.println("Quantity must larger than saled! Enter again!");
            return;
        }
        System.out.print("Enter price: ");
        double price = Validate.checkInputDouble();
        if (ProductInter.checkProductExist(pcode)) {
            System.err.print("Pcode already exist!");
        } else {
            System.err.println("Add success");
            ProductInter.addProduct(pcode, pro_name, quantity, saled, price);

        }
    }

    public static void addProductIndex() {
        System.out.print("Enter pcode: ");
        String pcode = Validate.checkInputString();
        System.out.print("Enter pro_name: ");
        String pro_name = Validate.checkInputString();
        System.out.print("Enter quantity: ");
        int quantity = Validate.checkInputInt();
        System.out.print("Enter saled: ");
        int saled = Validate.checkInputInt();
        System.out.print("Enter price: ");
        double price = Validate.checkInputDouble();
        System.out.print("Enter index you want to add: ");
        int index = Validate.checkInputInt();
        if (ProductInter.checkProductExist(pcode)) {
            System.err.print("Pcode already exist!");
            return;
        }
        if (!productInter.checkInputIndex(index)) {
            System.err.println("Index must smaller than size of the list!");
            return;
        }
        ProductInter.addProductIndex(pcode, pro_name, quantity, saled, price, index);

    }

    public static void displayData() {
        ProductInter.displayData();
    }

    public static void saveProductToFile() throws IOException {
        System.err.println("Save success!");
        ProductInter.saveProductToFile();
        
    }

    public static void deleteProduct() {
        System.out.print("Enter pcode: ");
        String pcode = Validate.checkInputString();
        ProductInter.deleteProduct(pcode);

    }

    public static void searchProductByCode() {
        System.out.print("Enter pcode you want to search: ");
        String pcode = Validate.checkInputString();
        ProductInter.getProductByCode(pcode);
    }

    public static void sortProductByCode() {
        ProductInter.sortProductByCode();
    }

    public static void deleteBefore() {
        System.out.print("Enter pcode: ");
        String pcode = Validate.checkInputString();
        productInter.deleteBefore(pcode);
    }
}
