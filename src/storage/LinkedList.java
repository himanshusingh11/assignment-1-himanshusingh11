package storage;

import adt.People;

import java.util.Arrays;

public class LinkedList {
    Node head;

    public void insert(People data) {
        Node.size = Node.size + 1;
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public String[] showInput() {
        Node node = head;
        String[] list = new String[Node.size];
        int counter = 0;
        try {
            while (node.next != null) {
                list[counter] = node.data.getFirstName() + "!" + node.data.getLastName() + " " + node.data.getNumber() +
                        "!" + node.data.getEmail();
                counter++;
                node = node.next;
            }
            list[counter] = node.data.getFirstName() + "!" + node.data.getLastName() + " " + node.data.getNumber() +
                    "!" + node.data.getEmail();
        } catch (NullPointerException e) {
            System.out.println("Empty ContactList");

        }
        Arrays.sort(list);
        return list;
    }

    public Node delete(String del) {
        Node.size = Node.size - 1;
        String[] name = del.split(" ");
        System.out.println(name[0] + " " + name[1] + "'s contact deleted from list!\n");
        try {
            Node d = head;
            Node previous = null;
            if (d.data.getFirstName().equals(name[0]) && d.data.getLastName().equals(name[1])) {

                head = d.next;
            } else {
                while (!d.data.getFirstName().equals(name[0]) || !d.data.getLastName().equals(name[1])) {
                    previous = d;
                    d = d.next;
                }
                previous.next = d.next;
            }
            return d;
        } catch (NullPointerException e) {
            System.out.println("No Such Contact Exist.");
            return null;
        }
    }

}
