import java.util.Scanner;
import model.Patient;
import model.Visit;
import model.TreatmentRecord;
import datastructures.PatientBST;
import datastructures.EmergencyQueue;
import datastructures.TreatmentStack;

public class Main {

    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1: addPatient(); break;
                case 2: searchPatient(); break;
                case 3: deletePatient(); break;
                case 4: patientBST.inorderTraversal(); break;
                case 5: enqueuePatient(); break;
                case 6: dequeuePatient(); break;
                case 7: emergencyQueue.displayQueue(); break;
                case 8: completeTreatment(); break;
                case 9: undoLastTreatment(); break;
                case 10: treatmentStack.displayStack(); break;
                case 11: addVisit(); break;
                case 12: removeVisit(); break;
                case 13: searchVisit(); break;
                case 14: displayVisitHistory(); break;
                case 0: System.out.println("Exiting system. Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        } while (choice != 0);

        sc.close();
    }

    private static void printMenu() {
        System.out.println("===== Mini Hospital Emergency Management System =====");
        System.out.println("1. Add New Patient (BST)");
        System.out.println("2. Search Patient by ID (BST)");
        System.out.println("3. Delete Patient (BST)");
        System.out.println("4. Display All Patients (Inorder Traversal)");
        System.out.println("5. Add Patient to Emergency Queue");
        System.out.println("6. Treat Next Patient (Dequeue)");
        System.out.println("7. Display Waiting Queue");
        System.out.println("8. Complete Treatment (Push to Stack)");
        System.out.println("9. Undo Last Completed Treatment (Pop)");
        System.out.println("10. Display Treatment History (Stack)");
        System.out.println("11. Add Visit to Patient History");
        System.out.println("12. Remove Visit from Patient History");
        System.out.println("13. Search Visit in Patient History");
        System.out.println("14. Display Patient Visit History");
        System.out.println("0. Exit");
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Enter a number.");
            sc.next();
            System.out.print(prompt);
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    // ---------- BST Operations ----------
    private static void addPatient() {
        int id = getIntInput("Enter Patient ID: ");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        int age = getIntInput("Enter Age: ");
        System.out.print("Enter Contact Number: ");
        String contact = sc.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = sc.nextLine();

        Patient patient = new Patient(id, name, age, contact, condition);
        patientBST.insert(patient);
        System.out.println("Patient added successfully.");
    }

    private static void searchPatient() {
        int id = getIntInput("Enter Patient ID to search: ");
        Patient found = patientBST.search(id);
        if (found != null) {
            System.out.println("Patient found: " + found);
        } else {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }

    private static void deletePatient() {
        int id = getIntInput("Enter Patient ID to delete: ");
        patientBST.delete(id);
        System.out.println("Delete operation completed.");
    }

    // ---------- Queue Operations ----------
    private static void enqueuePatient() {
        int id = getIntInput("Enter Patient ID to add to queue: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found in records. Add patient first.");
            return;
        }
        emergencyQueue.enqueue(patient);
    }

    private static void dequeuePatient() {
        Patient next = emergencyQueue.dequeue();
        if (next != null) {
            System.out.println("Now treating: " + next);
        }
    }

    // ---------- Stack Operations ----------
    private static void completeTreatment() {
        int id = getIntInput("Enter Patient ID whose treatment is completed: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found in records.");
            return;
        }
        System.out.print("Enter treatment given: ");
        String treatment = sc.nextLine();
        System.out.print("Enter completion time (e.g. 14:30): ");
        String time = sc.nextLine();

        TreatmentRecord record = new TreatmentRecord(id, patient.getName(), treatment, time);
        treatmentStack.push(record);
    }

    private static void undoLastTreatment() {
        TreatmentRecord removed = treatmentStack.pop();
        if (removed != null) {
            System.out.println("Removed record: " + removed);
        }
    }

    // ---------- Linked List Operations ----------
    private static void addVisit() {
        int patientId = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        int visitId = getIntInput("Enter Visit ID: ");
        System.out.print("Enter Visit Date: ");
        String date = sc.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = sc.nextLine();
        System.out.print("Enter Treatment: ");
        String treatment = sc.nextLine();

        Visit visit = new Visit(visitId, date, doctor, diagnosis, treatment);
        patient.getVisitHistory().addVisit(visit);
    }

    private static void removeVisit() {
        int patientId = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        int visitId = getIntInput("Enter Visit ID to remove: ");
        boolean removed = patient.getVisitHistory().removeVisit(visitId);
        if (removed) {
            System.out.println("Visit removed successfully.");
        }
    }

    private static void searchVisit() {
        int patientId = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        int visitId = getIntInput("Enter Visit ID to search: ");
        Visit visit = patient.getVisitHistory().searchVisit(visitId);
        if (visit != null) {
            System.out.println("Visit found: " + visit);
        } else {
            System.out.println("Visit ID " + visitId + " not found.");
        }
    }

    private static void displayVisitHistory() {
        int patientId = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.println("Visit history for " + patient.getName() + ":");
        patient.getVisitHistory().displayHistory();
    }
}