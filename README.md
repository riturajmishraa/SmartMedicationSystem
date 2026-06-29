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
- Git
- Github
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

<img width="1976" height="1390" alt="Screenshot 2026-06-29 090401" src="https://github.com/user-attachments/assets/4a186f12-b96b-4c41-8312-8e0e1e648093" />



---

### Add Medicine

<img width="1978" height="1384" alt="image" src="https://github.com/user-attachments/assets/efc71fe9-d111-4650-bba5-953c4396eb5f" />


---

### Inventory

<img width="1978" height="1384" alt="image" src="https://github.com/user-attachments/assets/191b51e1-e144-45e7-99d0-790be1843d28" />


---

### Low Stock Alert

<img width="1978" height="1390" alt="image" src="https://github.com/user-attachments/assets/83607a40-24c7-4b1e-bdb5-6b49b7b8087f" />


---

### Next Medicine

<img width="1970" height="1384" alt="image" src="https://github.com/user-attachments/assets/4b005b63-738d-4ac2-9c64-df9c8d74daa2" />


---


### Expiry Alert

<img width="1974" height="1388" alt="image" src="https://github.com/user-attachments/assets/3f9b7369-e3a1-479a-8037-439a21da0b30" />


---

### History

<img width="1974" height="1388" alt="image" src="https://github.com/user-attachments/assets/b0f565dc-767c-4440-aabe-cec3c4a24ebf" />


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

- User Login & Authentication
- SQLite / MySQL Database Integration
- Desktop Notifications
- Email & SMS Medicine Reminders
- Dark Mode
- Medicine Images
- Export Reports (PDF/Excel)
- Calendar Integration
- Multi-user Support
- Cloud Data Backup

---

## ⭐ Version

Current Release: **v1.0**

This version includes:

- Modern Dashboard UI
- Add Medicine
- Inventory Management
- Search Medicine
- Delete Medicine
- Undo Delete
- Next Medicine Reminder
- Low Stock Alert
- Expiry Alert
- History Tracking
- Local File Storage


---


## 👨‍💻 Author

**Rituraj Mishra**

Computer Science Engineering Student

Aspiring Software Developer

GitHub:
https://github.com/riturajmishraa
