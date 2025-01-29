package com.Assignment2;
import java.util.ArrayList;
import java.util.Scanner;
abstract class Room {
    int roomNumber;
    boolean isBooked;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }

    abstract void showRoomType();

    public void bookRoom() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Room " + roomNumber + " is booked successfully.");
        } else {
            System.out.println("Room " + roomNumber + " booked already.");
        }
    }

    public void checkoutRoom() {
        if (isBooked) {
            isBooked = false;
            System.out.println("Room " + roomNumber + " is now available for booking.");
        } else {
            System.out.println("Room " + roomNumber + " is already available for booking.");
        }
    }
}
class StandardRoom extends Room {
    public StandardRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    void showRoomType() {
        System.out.println("Standard Room - Room Number: " + roomNumber);
    }
}
class DeluxeRoom extends Room {
    public DeluxeRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    void showRoomType() {
        System.out.println("Deluxe Room - Room Number: " + roomNumber);
    }
}
public class Hotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new StandardRoom(101));
        rooms.add(new DeluxeRoom(102));

        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            room.showRoomType();
        }

        System.out.println("Enter room number for booking:");
        int roomNumber = sc.nextInt();
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                room.bookRoom();
                break;
            }
        }

        sc.close();
    }
}
