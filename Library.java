package com.Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    boolean isIssued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

class Member {
    int memberId;
    String name;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}

class Transaction {
    int bookId;
    int memberId;

    public Transaction(int bookId, int memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
    }
}

public class Library {
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();
    static ArrayList<Transaction> transactions = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Add Book\n2. Add Member\n3. Issue Book\n4. Return Book\n5. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: addBook(); break;
                case 2: addMember(); break;
                case 3: issueBook(); break;
                case 4: returnBook(); break;
            }
        } while (choice != 5);
    }

    static void addBook() {
        System.out.println("Enter Book ID, Title, and Author:");
        books.add(new Book(sc.nextInt(), sc.next(), sc.next()));
        System.out.println("Book Added!");
    }

    static void addMember() {
        System.out.println("Enter Member ID and Name:");
        members.add(new Member(sc.nextInt(), sc.next()));
        System.out.println("Member Added!");
    }

    static void issueBook() {
        System.out.println("Enter Book ID and Member ID:");
        int bookId = sc.nextInt();
        int memberId = sc.nextInt();
        for (Book book : books) {
            if (book.bookId == bookId && !book.isIssued) {
                book.isIssued = true;
                transactions.add(new Transaction(bookId, memberId));
                System.out.println("Book Issued!");
                return;
            }
        }
        System.out.println("Book Not Available!");
    }

    static void returnBook() {
        System.out.println("Enter Book ID:");
        int bookId = sc.nextInt();
        for (Book book : books) {
            if (book.bookId == bookId && book.isIssued) {
                book.isIssued = false;
                System.out.println("Book Returned!");
                return;
            }
        }
        System.out.println("Invalid Book ID!");
    }
}

