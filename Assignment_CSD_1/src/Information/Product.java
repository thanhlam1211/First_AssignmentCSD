/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Information;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Product {

    public String pcode;
    public String pro_name;
    public int quantity;
    public int saled;
    public double price;

    public Product(String pcode, String pro_name, int quantity, int saled, double price) {
        this.pcode = pcode;
        this.pro_name = pro_name;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    public Product() {
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSaled() {
        return saled;
    }

    public void setSaled(int saled) {
        this.saled = saled;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void printProduct() {
        System.out.printf("%5s|%11s|%10s|%8s|%8s\n", "pcode", "pro_name", "quantity", "saled", "price");
        System.out.println("=======================================================");
        System.out.printf("%5s|%11s|%10s|%8s|%8s\n", pcode, pro_name, quantity, saled, price);
    }

    @Override
    public String toString() {
        return pcode + ", " + pro_name + ", " + quantity + ", " + saled + ", " + price;
    }
}
