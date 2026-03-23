# 📘 Grade Management System Documentation

---

## 📌 1. Introduction
The Grade Management System is a Java-based console application that manages student academic records. It allows users to input marks, calculate averages, assign grades, and generate performance reports.

---

## 🎯 2. Objectives
- Store student marks efficiently
- Perform calculations on student data
- Generate detailed performance reports
- Apply Java programming concepts

---

## 🏗️ 3. System Architecture

### Components:

#### 1. GradeManagementSystem
- Main class
- Handles menu system and user interaction
- Controls program flow

#### 2. StudentGrade
- Stores student name and marks
- Uses array to store subject marks

#### 3. GradeCalculator
- Calculates:
  - Average marks
  - Highest marks
  - Lowest marks
- Determines grade based on average

#### 4. ReportGenerator
- Generates performance report
- Calculates subject averages
- Displays top performers
- Shows grade distribution

---

## 🔄 4. Program Flow
1. Program starts
2. Menu is displayed
3. User selects an option
4. System performs operation:
   - Add student
   - View students
   - Calculate averages
   - Find top performers
   - Generate report
5. Loop continues until exit

---

## 🧮 5. Algorithms Used

### 🔹 Average Calculation
- Sum all subject marks
- Divide by number of subjects

### 🔹 Grade Assignment
if avg >= 90 → A+
else if avg >= 80 → A
else if avg >= 70 → B
else if avg >= 60 → C
else if avg >= 50 → D
else → F

### 🔹 Top Performer Logic
- Sort students based on average marks (descending order)

### 🔹 Subject Average Calculation
- Sum marks of each subject across all students
- Divide by total number of students

---

## 📊 6. Data Structures Used
- ArrayList → stores student objects
- Array (double[]) → stores subject marks

---

## ⚠️ 7. Error Handling
- try-catch blocks used for:
  - Invalid numeric input
  - Incorrect data entry
- Input validation ensures:
  - Marks between 0–100
  - Menu choices within range

---

## 🧪 8. Testing

### Test Cases
| Scenario | Expected Result |
|---------|---------------|
| Marks > 100 | Error message |
| Invalid input | Retry prompt |
| Empty data | "No students found" |
| Normal input | Correct output |

---

## 📈 9. Sample Report Output
=== PERFORMANCE REPORT ===
Total Students: 3

📊 SUBJECT AVERAGES:
• Mathematics: 85.00
• Science: 83.00
• English: 89.33
• History: 83.33
• Computer: 86.00

🏆 TOP PERFORMERS:

1. Alice Johnson - Average: 88.80

📈 GRADE DISTRIBUTION:
• A Grade: 3 students

---

## 🚀 10. Future Improvements
- File storage (save/load student data)
- Graphical User Interface (GUI)
- Database integration
- Advanced analytics and charts

---

## 📚 11. Conclusion
This project successfully demonstrates core Java concepts including arrays, loops, conditionals, and object-oriented programming.

It provides a strong foundation for developing real-world applications.

---