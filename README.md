# 💰 Personal Budgeting System

**Personal Budgeting System** is a modular Java application designed to help users efficiently manage their finances. It enables tracking of expenses, income, savings goals, and reminders through a well-structured system built using the **Model-View-Controller (MVC)** architectural pattern.

---

## 📐 System Architecture

The system follows a layered architecture that separates responsibilities across clearly defined modules:

- **UI Layer** – Handles user interaction and interface display
- **Controller Layer** – Mediates between UI and services
- **Service Layer** – Implements business logic and validation
- **Domain Layer** – Defines core data models (e.g., `User`, `Expense`, `Reminder`, `Goal`, `Budget`)
- **Database Layer** – Simulates persistent storage using file-based Java serialization

This structure promotes modularity, maintainability, and ease of future enhancements.

---

## 🧩 Features

- 👤 **User Authentication** – Sign up, log in, and session management  
- 💸 **Expense Tracking** – Add, edit, and view categorized expenses  
- 💼 **Income Management** – Record multiple income sources and amounts  
- 🎯 **Savings Goals** – Define financial goals and monitor progress  
- 🧠 **Reminders** – Schedule financial task reminders with date/time  
- 📊 **Budgeting & Reports** – Set category-wise budget limits and view financial summaries  
- 💾 **Data Persistence** – All data stored using Java serialization for offline access

---

## 📁 Project Structure

project-root/
├── UI/
├── controller/
├── service/
├── domain/
├── database/
└── README.md

---

## 🗃️ Data Persistence (Database Simulation)

The system simulates a database using **Java Serialization**, allowing it to save and load data as serialized objects.

- All model classes implement `Serializable`
- Data is stored in `.ser` or `.txt` files
- Example storage classes:
  - `UserDB`
  - `ExpenseDB`
  - `ReminderDB`

This approach is ideal for small-scale or academic projects, offering simplicity and portability without external dependencies.

---

## 📄 Documentation

- All classes and methods are fully documented using **JavaDocs**
- Inline comments are included for clarity and maintainability
