/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
class Node {

    int data;
    Node next;

    Node(int data) {

        this.data = data;
        this.next = null;

    }

}

public class Linker {

    Node head;

    public Linker() {
        head = null;

    }

    public void AddHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }

    public void AddTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void Delete(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;

        }
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public boolean Search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void Print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Linker singly = new Linker();
        Scanner sc = new Scanner(System.in);

        int menu;

        do {
            System.out.println("");
            System.out.println("Menu");
            System.out.println("[1] Insert Head");
            System.out.println("[2] Insert Tail");
            System.out.println("[3] Delete");
            System.out.println("[4] Search");
            System.out.println("[5] Display");
            System.out.println("[6] Exit");
            System.out.println("");

            System.out.print("Choice: ");

            menu = sc.nextInt();

            switch (menu) {

                case 1:
                    System.out.print("Insert Head: ");
                    menu = sc.nextInt();
                    System.out.println("");
                    singly.AddHead(menu);
                    singly.Print();

                    break;

                case 2:
                    System.out.print("Insert Tail: ");
                    menu = sc.nextInt();
                    System.out.println("");
                    singly.AddTail(menu);
                    singly.Print();

                    break;

                case 3:
                    System.out.print("Delete: ");
                    menu = sc.nextInt();
                    singly.Delete(menu);
                    System.out.println("");
                    singly.Print();
                    break;
                case 4:
                    System.out.print("Search element: ");
                    menu = sc.nextInt();
                    System.out.println(singly.Search(menu));
                    

                    break;
                case 5:
                    System.out.print("Display: ");
                    singly.Print();
                    break;

                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("");
                    System.out.println("Error");

            }
        } while (menu != 6);
    }
}
