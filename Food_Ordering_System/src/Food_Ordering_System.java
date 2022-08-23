/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author My Computer
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Food_Ordering_System {
    
public static Scanner sc = new Scanner(System.in);
public static int choose;
public int order, quantity, delivery;
public String name, address, item;
public double price, subtotal, vat, total;
static ArrayList<Pending> arr = new ArrayList<>();
public static void main(String args[]){
    int option;
    do {
        System.out.println("Welcome to Food Ordering System!");
        System.out.println("a - Order");
        System.out.println("b - Pending Order/s");
        System.out.println("c - Exit");
        System.out.println("Choose a letter: ");
        option = sc.next().charAt(0);
        switch (option) {
            case 'a':{
                System.out.println("Specify no. of entries:");
                int counter = sc.nextInt();
                while (counter != 0) {
                    System.out.println("Order #: ");
                    int order = sc.nextInt();
                    System.out.println("Name: ");
                    String name = sc.next();
                    System.out.println("Address: ");
                    String address = sc.next();
                    System.out.println("Item: ");
                    String item = sc.next();
                    System.out.println("Quantity: ");
                    int quantity = sc.nextInt();
                    System.out.println("Price: ");
                    double price = sc.nextDouble();
                    System.out.println("Delivery fee: ");
                    int delivery = sc.nextInt(); 
                    double subtotal = (quantity * price) + delivery;
                    System.out.println("Subtotal: $"+ subtotal );
                    double vat = price * 0.12;
                    System.out.println("Vat: " + vat);
                    double total = subtotal + vat;
                    System.out.println("Total: $" + total);
                    Pending p = new Pending();
                    p.setOrder(order);
                    p.setName(name);
                    p.setAddress(address);
                    p.setItem(item);
                    p.setQuantity(quantity);
                    p.setPrice(price);
                    p.setDelivery(delivery);
                    p.setSubtotal(subtotal);
                    p.setVat(vat);
                    p.setTotal(total);
                    p.setStatus("Pending");
                    insertPending(p, arr);
                    --counter;
                    System.out.println();
                }
                break;
            }
            case 'b':{
                System.out.println("List of Pending orders: ");
                pendingList(arr);
                System.out.println();
                System.out.println("What do you want to do?(choose a number) ");
                System.out.println("1 - Deliver order ");
                System.out.println("2 - Cancel order ");
                choose = sc.nextInt();
                if(choose==1){
                    System.out.println("Enter Order #: ");
                    int o = sc.nextInt();
                    Iterator<Pending> it = arr.iterator();
                    while (it.hasNext()) {
                    Pending p = it.next();
                        if (p.getOrder() == o) {
                            p.setStatus("Delivered");
                            System.out.println("Order Delivered!");  
                            System.out.println();
                        }
                        else if (p.getOrder() != o) {
                            System.out.println("The order doesn't exist!");
                            System.out.println();
                        }
                    }
                    break;
                }
                if(choose==2){
                    System.out.println("Enter Order #: ");
                    int o = sc.nextInt();
                    Iterator<Pending> it = arr.iterator();
                    while (it.hasNext()) {
                    Pending p = it.next();
                        if (p.getOrder() == o) {
                            p.setStatus("Cancelled");
                            System.out.println("Order Cancelled!");
                            System.out.println();
                        }
                        else if (p.getOrder() != o){
                            System.out.println("The order doesn't exist!");
                            System.out.println();
                        }
                    }
                }
                break;
            }
            case 'c': {
                System.out.println(">>>>>Come back again!<<<<<");
                System.exit(0);               
                break;
            }
            default: {
                System.out.println("Invalid Option!");
                System.out.println();
                break;
            }
        }
    }
    while (option != 5);
}
static void insertPending(Pending p, ArrayList arr) {
        arr.add(p);
}
static void pendingList ( ArrayList arr) {
    if (arr.isEmpty()) {
        System.out.println(">>>Empty List");
    } else {
        Iterator<Pending> pe = arr.iterator();
        int counter = 0;
        while (pe.hasNext()) {
            Pending p = pe.next();
            ++counter;
            System.out.println("(" + counter + ")"+ " Order #: " + p.getOrder() + " Name: " + p.getName()
            + " Address: " + p.getAddress() + " Item: " + p.getItem() + " Total: $" + p.getTotal()
            + " Status: " + p.getStatus());
        }
    }
}
}
