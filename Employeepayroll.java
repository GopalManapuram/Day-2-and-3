package com.Assignment2;
abstract class Employee {
    int empId;
    String name;
    double baseSalary;

    public Employee(int empId, String name, double baseSalary) {
        this.empId = empId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary(); 
}
class PermanentEmployee extends Employee {
    public PermanentEmployee(int empId, String name, double baseSalary) {
        super(empId, name, baseSalary);
    }

    @Override
    double calculateSalary() {
        return baseSalary + (baseSalary * 0.2); 
    }
}
class ContractualEmployee extends Employee {
    public ContractualEmployee(int empId, String name, double baseSalary) {
        super(empId, name, baseSalary);
    }

    @Override
    double calculateSalary() {
        return baseSalary; 
    }
}
public class Employeepayroll {
    public static void main(String[] args) {
        Employee permEmp = new PermanentEmployee(101, "Alice", 50000);
        Employee contEmp = new ContractualEmployee(102, "Bob", 40000);

        System.out.println("Salary of " + permEmp.name + ": " + permEmp.calculateSalary());
        System.out.println("Salary of " + contEmp.name + ": " + contEmp.calculateSalary());
    }
}


