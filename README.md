# 💰 Personal Budgeting System

This is a Java-based personal budgeting system that helps users manage their expenses, income, savings goals, and reminders through a clean, modular design based on the MVC architecture.

---

## 📐 Architecture Overview

The system follows the **MVC (Model-View-Controller)** architecture, with a clear separation between:

- **UI Layer** – Handles user interactions
- **Controller Layer** – Connects UI to business logic
- **Service Layer** – Contains business rules and application logic
- **Database Layer** – Manages data persistence using file-based storage
- **Domain Layer** – Contains the core data models

This structure ensures modularity, reusability, and maintainability of the code.

---

## 🧩 Main Features

- 👤 **User Login / Signup**
- 💸 **Expense Tracking**
- 💼 **Income Management**
- 🎯 **Savings Goals**
- 🧠 **Reminders & Notifications**
- 📊 **Budgeting and Reports**
- 📁 **Data Persistence using Serialization**

---

## 📂 Code Structure

project-root/
│
├── UI/ # User interfaces (console-based)
├── controller/ # Controllers linking UI and services
├── service/ # Business logic and rule enforcement
├── domain/ # Core data models (Reminder, Expense, User, etc.)
├── database/ # File-based database simulation
└── README.md # This file


---

## 🗃️ Data Persistence (Database Layer)

Instead of using a traditional database, we simulate data storage using **Java Serialization**:

- All model classes implement the `Serializable` interface.
- Data is stored and retrieved from `.ser` files.
- The `database` package contains classes like:
  - `UserDB`, `ReminderDB`, `ExpenseDB`  
- These handle reading/writing objects to and from disk.

This approach is lightweight and practical for academic or small-scale applications.

---

## 📄 Documentation

- The project is fully documented using **JavaDocs**.
- Each class and method includes descriptive comments.
