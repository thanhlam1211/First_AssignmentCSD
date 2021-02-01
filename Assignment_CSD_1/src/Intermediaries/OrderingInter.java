/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intermediaries;

import Entity.Manager;
import Information.Ordering;
import Information.Product;
import Node.MyList;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class OrderingInter {

    public OrderingInter() {
    }

    public void add(String pcode, String ccode, int quantity) {
        Product product = Manager.getProduct(pcode);
        Ordering ordering;
        if (Manager.checkExistProduct(ccode) && Manager.checkCustomerExist(ccode)) {
            if (Manager.checkExistOrdering(pcode, ccode) == -1) {
                if (product.getQuantity() == product.getSaled()) {
                    System.err.println("Product is exhausted!");
                } else {
                    ordering = new Ordering(pcode, ccode, quantity);
                    Manager.updateOrder(pcode);
                    Manager.addOrder(ordering);
                }
            } else if (product.getSaled() < product.getQuantity()
                    && quantity <= (product.getQuantity() - product.getSaled())) {
                ordering = new Ordering(pcode, ccode, quantity);
                Manager.updateOrder(pcode);
                Manager.addOrder(ordering);
            }
        } else {
            System.err.println("Product or Customer not found! Try again");
        }
    }

    public void display() {
        MyList<Ordering> orderingList = Manager.getOrderingList();
        System.out.printf("%5s|%5s|%5s\n", "Pcode", "Ccode", "Value");

        for(int i = 0; i < orderingList.size(); ++i) {
            Ordering currentOrder = orderingList.get(i);
            System.out.printf("%5s|%5s|%5d\n", currentOrder.getPcode(), currentOrder.getCcode(),
                    currentOrder.getQuantity());
        }

    }

    public void sortByBothCode() {
        Manager.sortOrdering();
    }

}
