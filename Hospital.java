package com.Assignment2;
import java.util.ArrayList;
import java.util.Scanner;
class Patient {
    int patientId;
    String name;

    public Patient(int patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }
}
class Doctor {
    int doctorId;
    String name;
    String specialty;

    public Doctor(int doctorId, String name, String specialty) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialty = specialty;
    }
}
class Appointment {
    int appointmentId;
    Patient patient;
    Doctor doctor;
    String dateTime;

    public Appointment(int appointmentId, Patient patient, Doctor doctor, String dateTime) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }

    public void printAppointmentDetails() {
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient: " + patient.name);
        System.out.println("Doctor: " + doctor.name + " (" + doctor.specialty + ")");
        System.out.println("Date and Time: " + dateTime);
    }
}
public class Hospital {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        doctors.add(new Doctor(1, "Dr. Smith", "Cardiologist"));
        doctors.add(new Doctor(2, "Dr. Lee", "Neurologist"));
        
        patients.add(new Patient(1, "John Doe"));
        patients.add(new Patient(2, "Jane Doe"));

        int choice;
        do {
            System.out.println("1. Schedule Appointment\n2. View Appointments\n3. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: scheduleAppointment(); break;
                case 2: viewAppointments(); break;
            }
        } while (choice != 3);
    }

    static void scheduleAppointment() {
        System.out.println("Enter Patient ID and Doctor ID:");
        int patientId = sc.nextInt();
        int doctorId = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.println("Enter Date and Time of Appointment (e.g., 2025-01-28 10:00):");
        String dateTime = sc.nextLine();

        try {
            Patient patient = findPatientById(patientId);
            Doctor doctor = findDoctorById(doctorId);

            int appointmentId = appointments.size() + 1;
            Appointment appointment = new Appointment(appointmentId, patient, doctor, dateTime);
            appointments.add(appointment);

            System.out.println("Appointment Scheduled!");
            appointment.printAppointmentDetails();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            for (Appointment appointment : appointments) {
                appointment.printAppointmentDetails();
            }
        }
    }

    static Patient findPatientById(int patientId) throws Exception {
        for (Patient patient : patients) {
            if (patient.patientId == patientId) {
                return patient;
            }
        }
        throw new Exception("Patient not found!");
    }

    static Doctor findDoctorById(int doctorId) throws Exception {
        for (Doctor doctor : doctors) {
            if (doctor.doctorId == doctorId) {
                return doctor;
            }
        }
        throw new Exception("Doctor not found!");
    }
}

