package com.Assignment2;
import java.util.Scanner;

abstract class Vehicle {
    String model;
    double rentalRate;

    public Vehicle(String model, double rentalRate) {
        this.model = model;
        this.rentalRate = rentalRate;
    }

    abstract double calculateRentalCost(int days);
}

class Car extends Vehicle {
    public Car(String model, double rentalRate) {
        super(model, rentalRate);
    }

    @Override
    double calculateRentalCost(int days) {
        return rentalRate * days;
    }
}

class Bike extends Vehicle {
    public Bike(String model, double rentalRate) {
        super(model, rentalRate);
    }
    @Override
    double calculateRentalCost(int days) {
        return rentalRate * days;
    }
}

class Customers {
    String name;
    Vehicle rentedVehicle;

    public Customers(String name) {
        this.name = name;
    }

    public void rentVehicle(Vehicle vehicle) {
        this.rentedVehicle = vehicle;
    }

    public void returnVehicle() {
        this.rentedVehicle = null;
    }
}
public class Vehiclerental {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create scanner object

        // Creating vehicles
        Vehicle car = new Car("Toyota Corolla", 50);
        Vehicle bike = new Bike("Yamaha FZ", 30);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();
        Customers customer = new Customers(customerName);

        // Customer chooses vehicle type
        System.out.println("Choose a vehicle to rent:");
        System.out.println("1. Car (Toyota Corolla, Rs 50/day)");
        System.out.println("2. Bike (Yamaha FZ, Rs 30/day)");
        int choice = sc.nextInt();

        if (choice == 1) {
            customer.rentVehicle(car);
        } else if (choice == 2) {
            customer.rentVehicle(bike);
        } else {
            System.out.println("Invalid choice. Exiting...");
            sc.close();
            return;
        }

        // Calculate rental cost
        System.out.print("Enter number of days for rental: ");
        int days = sc.nextInt();
        System.out.println("Rental cost: Rs " + customer.rentedVehicle.calculateRentalCost(days));

        // Returning vehicle
        customer.returnVehicle();
        System.out.println("Vehicle returned.");

        // Close scanner at the end
        sc.close();
    }
}
