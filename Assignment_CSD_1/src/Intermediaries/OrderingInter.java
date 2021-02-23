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
       Manager.addOrdering(pcode, ccode, quantity);
    }

    public void display() {
        MyList<Ordering> orderingList = Manager.getOrderingList();
        System.out.printf("%5s|%5s|%5s\n", "Pcode", "Ccode", "Value");

        for (int i = 0; i < orderingList.size(); ++i) {
            Ordering currentOrder = orderingList.get(i);
            System.out.printf("%5s|%5s|%5d\n", currentOrder.getPcode(), currentOrder.getCcode(),
                    currentOrder.getQuantity());
        }

    }

    public void sortByBothCode() {
        Manager.sortOrdering();
    }
    
    
    public String checkInputCcode(String ccode) {
        return Manager.checkInputCcode(ccode);
    }

    public String checkInputPcode(String pcode) {
        return Manager.checkInputPcode(pcode);
    }


}
