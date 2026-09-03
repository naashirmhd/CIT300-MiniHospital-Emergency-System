package datastructures;

import model.TreatmentRecord;

public class TreatmentStack {

    private class SNode {
        TreatmentRecord record;
        SNode next;

        SNode(TreatmentRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    private SNode top;
    private int size;

    public TreatmentStack() {
        top = null;
        size = 0;
    }

    // ---------- PUSH ----------
    public void push(TreatmentRecord record) {
        SNode newNode = new SNode(record);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Treatment record for " + record.getPatientName() + " added to history.");
    }

    // ---------- POP ----------
    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Treatment history is empty. Nothing to remove.");
            return null;
        }
        TreatmentRecord removed = top.record;
        top = top.next;
        size--;
        return removed;
    }

    // ---------- IS EMPTY ----------
    public boolean isEmpty() {
        return top == null;
    }

    // ---------- DISPLAY ----------
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("No treatment records found.");
            return;
        }
        System.out.println("Treatment history (most recent first):");
        SNode temp = top;
        int position = 1;
        while (temp != null) {
            System.out.println(position + ". " + temp.record);
            temp = temp.next;
            position++;
        }
    }

    public int getSize() {
        return size;
    }
}