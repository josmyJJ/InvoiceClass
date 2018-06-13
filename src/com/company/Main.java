package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        System.out.println("Date " + currentDate);
        System.out.println("Time " + currentTime);


        String quit = "yes";
        double subTotal = 0.0;

        Invoice invoice = new Invoice();

        System.out.print("Please enter your name: ");
        String inputName = input.nextLine();

        invoice.setCustomerName(inputName);
        invoice.setTransactionDate(currentDate);

        ArrayList<LineItem> items = new ArrayList<>();


        while (quit.equalsIgnoreCase("yes")){
            LineItem item = new LineItem();

            System.out.print("Enter your item code: ");
            String itemcode = input.next();

            System.out.print("Enter your item name: ");
            input.nextLine();
            String itemName = input.nextLine();

            System.out.print("Enter your item price: ");
            double itemPrice = input.nextDouble();

            System.out.print("Enter your item quantity: ");
            int quantity = input.nextInt();

            item.setItemCode(itemcode);
            item.setItemName(itemName);
            item.setPrice(itemPrice);
            item.setQuantity(quantity);
            item.setSubTotal(itemPrice * quantity);

            subTotal += item.getSubTotal();
            items.add(item);

            System.out.print("Do you want to add more item? (yes/no): ");
            input.nextLine();
            quit = input.nextLine();

            if(quit.equalsIgnoreCase("no")){
                System.out.println();
                System.out.println("Customer Invoice");
                System.out.println("----------------------------------------");
                System.out.println("Customer Name: " + invoice.getCustomerName());
                System.out.println("Transaction Date: " + invoice.getTransactionDate());
                System.out.println();
                System.out.println("Name"+"\t\t"+"Description"+"\t\t"+"Price"+"\t\t"+"Quantity"+"\t\t"+"Subtotal");
                for(LineItem itemList: items){
                    System.out.println(itemList.getItemCode() +"\t\t"+ itemList.getItemName() +"\t\t" +
                    itemList.getPrice() + "\t\t"+ itemList.getQuantity() + "\t\t" + itemList.getSubTotal());
                }
                System.out.println();
                System.out.println("Subtotal: $" + subTotal);
                double tax = subTotal * .06;
                double grandTotal = subTotal + tax;
                System.out.println("Tax: " + tax);
                System.out.println("Grand Total: $" + grandTotal);

            }
        }
    }
}
