package datastructures;

import model.Visit;

public class VisitLinkedList {

    private class LNode {
        Visit visit;
        LNode next;

        LNode(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private LNode head;

    public VisitLinkedList() {
        head = null;
    }

    // ---------- ADD VISIT ----------
    public void addVisit(Visit visit) {
        LNode newNode = new LNode(visit);
        if (head == null) {
            head = newNode;
        } else {
            LNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Visit ID " + visit.getVisitId() + " added to history.");
    }

    // ---------- REMOVE VISIT ----------
    public boolean removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visit history to remove from.");
            return false;
        }

        // If head itself is the visit to remove
        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            return true;
        }

        LNode current = head;
        while (current.next != null) {
            if (current.next.visit.getVisitId() == visitId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        System.out.println("Visit ID " + visitId + " not found.");
        return false;
    }

    // ---------- SEARCH VISIT ----------
    public Visit searchVisit(int visitId) {
        LNode temp = head;
        while (temp != null) {
            if (temp.visit.getVisitId() == visitId) {
                return temp.visit;
            }
            temp = temp.next;
        }
        return null;
    }

    // ---------- DISPLAY HISTORY ----------
    public void displayHistory() {
        if (head == null) {
            System.out.println("No visit history found.");
            return;
        }
        LNode temp = head;
        while (temp != null) {
            System.out.println(temp.visit);
            temp = temp.next;
        }
    }
}
