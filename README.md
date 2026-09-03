# CIT300 - Mini Hospital Emergency Management System

## 📌 Assignment Information

* **Module:** CIT300 - Data Structures and Algorithms
* **Assignment:** Individual Mid Assignment
* **Title:** Mini Hospital Emergency Management System Using Data Structures
* **Author:** AM.Naashir
* **Student ID:** 23DA2-0650
* **Programming Language:** Java
* **GitHub Repository:** CIT300-MiniHospital-Emergency-System

---

## 📖 Project Overview

The **Mini Hospital Emergency Management System** is a Java console-based application developed for the CIT300 - Data Structures and Algorithms Individual Mid Assignment.

The system simulates basic hospital emergency management activities, including:

* Registering new patients
* Searching and deleting patient records
* Displaying patients in ascending order of Patient ID
* Managing patients waiting for emergency treatment
* Recording completed treatments
* Undoing the most recently completed treatment
* Maintaining individual patient visit histories

The main purpose of this project is to demonstrate the practical implementation and use of fundamental data structures in Java.

The core data structures are implemented manually using custom node classes rather than using Java's built-in collection classes such as `ArrayList`, `LinkedList`, `Stack`, or `Queue`.

---

## 🧩 Data Structures Used

| No. | Data Structure               | Purpose                                                            | Main Operations                           |
| --- | ---------------------------- | ------------------------------------------------------------------ | ----------------------------------------- |
| 1   | **Binary Search Tree (BST)** | Stores and manages patient records using Patient ID as the key     | Insert, Search, Delete, Inorder Traversal |
| 2   | **Queue**                    | Manages patients waiting for emergency treatment                   | Enqueue, Dequeue, Display                 |
| 3   | **Stack**                    | Stores completed treatment records and supports undo functionality | Push, Pop, Display                        |
| 4   | **Singly Linked List**       | Maintains the previous hospital visits of each patient             | Add, Remove, Search, Display              |

---

## 🌳 1. Patient Records - Binary Search Tree

Patient records are stored using a **Binary Search Tree (BST)**.

The **Patient ID** is used as the key for organising the tree.

### BST Operations

* **Insert** - Adds a new patient record.
* **Search** - Searches for a patient using Patient ID.
* **Delete** - Removes a patient record from the BST.
* **Inorder Traversal** - Displays patients in ascending order of Patient ID.

### BST Deletion

The deletion algorithm handles the three standard BST cases:

1. Node with no children
2. Node with one child
3. Node with two children

For a node with two children, the **inorder successor** is used to maintain the BST structure.

---

## 🚑 2. Emergency Patient Queue

A custom linked-node **Queue** is used to manage patients waiting for emergency treatment.

The queue follows the:

**FIFO - First-In, First-Out**

principle.

### Queue Operations

* **Enqueue** - Adds a patient to the end of the waiting queue.
* **Dequeue** - Removes the patient at the front of the queue for treatment.
* **Display** - Displays all currently waiting patients.
* **Empty Queue Handling** - Displays an appropriate message when no patients are waiting.

### Example

```text
Patient A → Patient B → Patient C

Dequeue → Patient A
```

The patient who enters the queue first is treated first.

---

## 📚 3. Treatment History - Stack

A custom linked-node **Stack** is used to store completed treatment records.

The stack follows the:

**LIFO - Last-In, First-Out**

principle.

### Stack Operations

* **Push** - Adds a completed treatment record to the stack.
* **Pop** - Removes the most recently completed treatment record.
* **Display** - Displays treatment records from most recent to oldest.
* **Empty Stack Handling** - Displays an appropriate message when there are no treatment records.

### Example

```text
Push → Treatment A
Push → Treatment B
Push → Treatment C

Pop → Treatment C
```

Therefore, the most recently completed treatment can be removed first using the undo operation.

---

## 🔗 4. Patient Visit History - Singly Linked List

Each `Patient` object contains its own **Singly Linked List** for maintaining previous hospital visits.

This allows each patient's visit history to be stored separately.

Each visit record contains:

* Visit ID
* Visit Date
* Doctor Name
* Diagnosis
* Treatment

### Linked List Operations

* **Add Visit** - Adds a new visit to the patient's history.
* **Remove Visit** - Removes a visit using Visit ID.
* **Search Visit** - Searches for a visit using Visit ID.
* **Display History** - Displays all visits belonging to the selected patient.

### Example

```text
Patient
   |
   v
Visit 001 → Visit 002 → Visit 003 → null
```

---

## 🗂️ Project Structure

```text
CIT300-Hospital-Emergency-System/
│
├── src/
│   ├── Main.java
│   │
│   ├── model/
│   │   ├── Patient.java
│   │   ├── Visit.java
│   │   └── TreatmentRecord.java
│   │
│   └── datastructures/
│       ├── PatientBST.java
│       ├── EmergencyQueue.java
│       ├── TreatmentStack.java
│       └── VisitLinkedList.java
│
└── README.md
```

### Package Description

#### `model`

Contains the classes used to represent application data:

* `Patient.java`
* `Visit.java`
* `TreatmentRecord.java`

#### `datastructures`

Contains the custom implementations of the required data structures:

* `PatientBST.java`
* `EmergencyQueue.java`
* `TreatmentStack.java`
* `VisitLinkedList.java`

#### `Main.java`

Contains the main menu, user input handling, and integration of all data structures.

---

## 📋 System Menu

The application provides the following menu options:

```text
===== Mini Hospital Emergency Management System =====

1. Add New Patient (BST)
2. Search Patient by ID (BST)
3. Delete Patient (BST)
4. Display All Patients (Inorder Traversal)
5. Add Patient to Emergency Queue
6. Treat Next Patient (Dequeue)
7. Display Waiting Queue
8. Complete Treatment (Push to Stack)
9. Undo Last Completed Treatment (Pop)
10. Display Treatment History (Stack)
11. Add Visit to Patient History
12. Remove Visit from Patient History
13. Search Visit in Patient History
14. Display Patient Visit History
0. Exit
```

---

## ✨ Key Features

### Patient Management

* Add new patient records.
* Search patients using Patient ID.
* Delete patient records from the BST.
* Display all patients using inorder traversal.

### Emergency Queue Management

* Add registered patients to the emergency queue.
* Treat the next waiting patient.
* Display patients currently waiting.
* Handle an empty queue appropriately.

### Treatment Management

* Record completed treatments.
* Store completed treatments using a Stack.
* Display treatment history.
* Undo the most recently completed treatment.

### Patient Visit Management

* Maintain a separate visit history for each patient.
* Add new hospital visits.
* Remove visits.
* Search visits.
* Display previous visit records.

### Input Handling

The application includes basic input validation for numeric inputs and handles searches or operations involving patients that do not exist.

---

## 🛠️ Design Decisions

### 1. Binary Search Tree for Patient Records

A BST was selected because Patient ID can be used as the key to efficiently organise patient records. Inorder traversal also allows the records to be displayed in ascending Patient ID order.

### 2. Queue for Emergency Patients

A Queue is suitable for managing waiting patients because it follows FIFO. Therefore, the patient who enters the waiting queue first is processed first.

### 3. Stack for Treatment History

A Stack is suitable for completed treatment records because it follows LIFO. This makes it suitable for the **Undo Last Completed Treatment** operation.

### 4. Singly Linked List for Visit History

A Singly Linked List allows multiple visit records to be stored sequentially for each patient. Each `Patient` object owns its own `VisitLinkedList`, keeping visit information associated with the correct patient.

### 5. Custom Node-Based Implementation

The required data structures were implemented using custom node classes:

* `Node` for BST
* `QNode` for Queue
* `SNode` for Stack
* `LNode` for Singly Linked List

This was done to demonstrate the underlying concepts of the data structures rather than relying on Java collection classes.

### 6. Package Separation

The project separates data models and data structure implementations into different packages:

```text
model
datastructures
```

This makes the project structure easier to understand and maintain.

---

## 🧪 Testing and Demonstration

The system was tested by performing the main operations provided in the menu.

Examples include:

### BST Testing

```text
Add Patient
Search Patient
Display Patients using Inorder Traversal
Delete Patient
```

### Queue Testing

```text
Enqueue Patient
Display Waiting Queue
Dequeue Patient
```

### Stack Testing

```text
Complete Treatment
Display Treatment History
Undo Last Completed Treatment
```

### Linked List Testing

```text
Add Visit
Display Visit History
Search Visit
Remove Visit
```

The system also includes handling for empty Queue and Stack conditions.

---

## 📹 Development & Demonstration Video

The development and demonstration video presents the completed project and demonstrates the main functionality of the system.

The video includes:

1. Brief introduction to the project
2. Explanation of the hospital emergency management system
3. Project structure and Java source code
4. Explanation of the four implemented data structures
5. GitHub repository and development history
6. Demonstration of the program running
7. Demonstration of important BST operations
8. Demonstration of Queue operations
9. Demonstration of Stack operations
10. Demonstration of Singly Linked List operations
11. Explanation of important design decisions
12. Brief reflection on the learning outcomes

---

## 🐙 GitHub Development

The project is maintained in a GitHub repository to demonstrate the development process.

Repository:

**CIT300-Hospital-Emergency-System**

The repository contains:

* Java source code
* Project structure
* README documentation
* Development commit history

Meaningful commits are used to demonstrate the progressive development of the project.

---

## 📚 Learning Outcomes

Through this project, the following concepts were practised:

* Binary Search Tree implementation
* BST insertion, searching and deletion
* Inorder traversal
* Queue implementation using linked nodes
* FIFO principle
* Stack implementation using linked nodes
* LIFO principle
* Singly Linked List implementation
* Node-based data structure design
* Recursion
* Object-oriented programming in Java
* Encapsulation
* Package organisation
* Integration of multiple data structures into one application
* Testing and debugging
* Git and GitHub development workflow

---

## 📄 Academic Integrity

This is an **individual assignment** developed for the **CIT300 - Data Structures and Algorithms** module.

The project is intended to demonstrate the student's understanding of the data structures, algorithms, Java implementation, testing, and design decisions required by the assignment.

The source code and development history are maintained in the student's GitHub repository as part of the development evidence.

---

## 👩‍💻 Author

**AM.Naashir**
**Student ID:** 23DA2-0650

**Module:** CIT300 - Data Structures and Algorithms

**Project:** Mini Hospital Emergency Management System
