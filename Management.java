package com.Assignment2;

import java.util.ArrayList;

interface Supplier {
    void supplyProduct(Prod product, int quantity);
}
//Product class should only be defined once in the code
class Prod {
 int productId;
 String name;
 int quantity;
 double price;

 // Constructor for initializing the product details
 public Prod(int productId, String name, int quantity, double price) {
     this.productId = productId;
     this.name = name;
     this.quantity = quantity;
     this.price = price;
 }

 // Method to update the quantity of the product
 void updateQuantity(int quantity) {
     this.quantity += quantity;
 }

 // Method to display product details
 void displayProduct() {
     System.out.println("Product ID: " + productId);
     System.out.println("Name: " + name);
     System.out.println("Quantity: " + quantity);
     System.out.println("Price: Rs" + price);
 }
}



class SupplierA implements Supplier {
    public void supplyProduct(Prod product, int quantity) {
        product.updateQuantity(quantity);
        System.out.println("Supplied " + quantity + " units of " + product.name + " from Supplier A.");
    }
}

class Inventory {
    ArrayList<Prod> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    void addProduct(Prod product) {
        products.add(product);
        System.out.println("Product added: " + product.name);
    }

    void removeProduct(int productId) {
        products.removeIf(product -> product.productId == productId);
        System.out.println("Product removed.");
    }

    void checkLowStock() {
        for (Prod product : products) {
            if (product.quantity < 10) {
                System.out.println("Low stock alert for " + product.name);
            }
        }
    }

    void displayInventory() {
        for (Prod product : products) {
            product.displayProduct();
        }
    }
}

public class Management {
    public static void main(String[] args) {
        Prod product1 = new Prod(1, "Laptop", 5, 1000);
        Prod product2 = new Prod(2, "Smartphone", 20, 700);

        Inventory inventory = new Inventory();
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        SupplierA supplier = new SupplierA();
        supplier.supplyProduct(product1, 10);
        
        inventory.checkLowStock();
        inventory.displayInventory();
    }
}
