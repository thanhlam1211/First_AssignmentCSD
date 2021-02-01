/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Node;

/**
 *
 * @author Thanh Lam <sguergachi at gmail.com>
 * @param <V>
 */
public class Node <V>{
    public V info;
    public Node<V> next;

    public Node() {
    }

    public Node(V info) {
        this.info = info;
    }

    public Node(V info, Node next) {
        this.info = info;
        this.next = next;
    }

}

