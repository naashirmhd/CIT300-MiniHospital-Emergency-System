package datastructures;

import model.Patient;

public class EmergencyQueue {

    private class QNode {
        Patient patient;
        QNode next;

        QNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private QNode front;
    private QNode rear;
    private int size;

    public EmergencyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // ---------- ENQUEUE ----------
    public void enqueue(Patient patient) {
        QNode newNode = new QNode(patient);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Patient " + patient.getName() + " added to emergency queue.");
    }

    // ---------- DEQUEUE ----------
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty. No patient to treat.");
            return null;
        }
        Patient treated = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return treated;
    }

    // ---------- IS EMPTY ----------
    public boolean isEmpty() {
        return front == null;
    }

    // ---------- DISPLAY ----------
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No patients currently waiting.");
            return;
        }
        System.out.println("Patients waiting in emergency queue:");
        QNode temp = front;
        int position = 1;
        while (temp != null) {
            System.out.println(position + ". " + temp.patient);
            temp = temp.next;
            position++;
        }
    }

    public int getSize() {
        return size;
    }
}
