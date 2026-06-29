# 💊 Smart Medication System

A desktop application built in **Java Swing** that helps users manage medicines, track inventory, receive medicine reminders, monitor low stock, and check upcoming expiry dates.

---

## 📌 Features

### ✅ Add Medicine
- Add medicine name
- Dosage
- Time
- Quantity
- Expiry Date
- Automatically stores data in text file

---

### 📦 Inventory Management
- View all medicines
- Search medicines
- Delete medicines
- Undo deleted medicine

---

### ⏰ Next Medicine Reminder
- Shows the next medicine based on the current system time.
- Ignores medicines whose time has already passed.

---

### ⚠ Low Stock Alert
Displays medicines whose quantity is less than 5.

Example:

Crocin (Qty: 3)

Paracetamol (Qty: 2)

---

### 📅 Expiry Alert
Shows medicines expiring within the next '30 days'.

---

### 📝 History
Keeps track of:

- Medicine Added
- Medicine Deleted
- Medicine Restored

---

### 💾 File Storage
All data is stored locally using text files.

No database required.

---

## 🛠 Technologies Used

- Java
- Java Swing
- OOP
- Collections Framework
- HashMap
- Priority Queue
- Stack
- File Handling
- VS Code

---

## 📂 Project Structure

src/
│
├── app/
├── model/
├── ui/
├── service/
├── storage/
├── datastructure/
│
assets/
data/

---

## 📁 Data Storage

Medicines are stored inside

data/medicines.txt

History is stored inside

data/history.txt

---

## 🚀 How to Run

### Compile

```bash
javac -d out src/app/*.java src/ui/*.java src/model/*.java src/service/*.java src/storage/*.java src/datastructure/*.java
```

### Run

```bash
java -cp out app.Main
```

---

## 📸 Screenshots

### Dashboard

<img width="1976" height="1390" alt="image" src="https://github.com/user-attachments/assets/cdceff15-55c0-4d19-8ce3-747532cb991e" />


---

### Add Medicine

<img width="1978" height="1384" alt="image" src="https://github.com/user-attachments/assets/efc71fe9-d111-4650-bba5-953c4396eb5f" />


---

### Inventory

<img width="1978" height="1384" alt="image" src="https://github.com/user-attachments/assets/191b51e1-e144-45e7-99d0-790be1843d28" />


---

## 🧠 Data Structures Used

| Data Structure | Purpose |
|---------------|---------|
| ArrayList | Store medicines |
| HashMap | Fast medicine search (O(1)) |
| Stack | Undo delete feature |
| Priority Queue | Next medicine reminder |

---

## 🎯 Future Improvements

- Login System
- User Authentication
- SQLite/MySQL Database
- Notifications
- Email Reminder
- Dark Mode
- Medicine Images
- Export Reports
- Calendar Integration

---

## 👨‍💻 Author

**Rituraj Mishra**

Computer Science Engineering Student

Aspiring Software Developer

GitHub:
https://github.com/riturajmishraa
