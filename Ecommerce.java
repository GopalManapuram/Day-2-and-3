package com.Assignment2;
import java.util.ArrayList;
import java.io.*;
class Product {
    int productId;
    String name;
    double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
}
class Order {
    int orderId;
    Product product;
    int quantity;
    double totalCost;

    public Order(int orderId, Product product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.totalCost = product.price * quantity;
    }

    public void printOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Product: " + product.name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + totalCost);
    }
}
class Customer {
    String customerName;
    ArrayList<Order> orders = new ArrayList<>();

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public void createOrder(Order order) {
        orders.add(order);
        System.out.println("Order Created for " + customerName);
    }
}
public class Ecommerce {

    public static void main(String[] args) {
        // Create Products
        Product product1 = new Product(101, "Laptop", 50000);
        Product product2 = new Product(102, "Smartphone", 30000);

        
        Customer customer = new Customer("Reigns");

        // Create Orders
        Order order1 = new Order(1, product1, 2); 
        Order order2 = new Order(2, product2, 1); 

        
        customer.createOrder(order1);
        customer.createOrder(order2);

        
        order1.printOrder();
        order2.printOrder();

        // Save Order to File
        saveOrderHistory(order1);
        saveOrderHistory(order2);
    }

    // Method to save order details to a file
    static void saveOrderHistory(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt", true))) {
            writer.write("Order ID: " + order.orderId + ", Product: " + order.product.name + ", Quantity: " + order.quantity + ", Total Cost: " + order.totalCost);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving order history: " + e.getMessage());
        }
    }
}

