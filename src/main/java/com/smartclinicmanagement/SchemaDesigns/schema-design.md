# Smart Clinic Management System - Database Schema Design

## MySQL Database Design

### Table: admin
- id: BIGINT, Primary Key, Auto Increment
- username: VARCHAR(50), NOT NULL, UNIQUE
- password: VARCHAR(255), NOT NULL
- email: VARCHAR(100), NOT NULL, UNIQUE

### Table: patients
- id: BIGINT, Primary Key, Auto Increment
- name: VARCHAR(100), NOT NULL
- email: VARCHAR(100), UNIQUE
- phone: VARCHAR(20), NULL
- created_at: DATETIME, default CURRENT_TIMESTAMP

### Table: doctors
- id: BIGINT, Primary Key, Auto Increment
- name: VARCHAR(100), NOT NULL
- email: VARCHAR(100), UNIQUE
- specialty: VARCHAR(50), NULL
- password: VARCHAR(255), NOT NULL
- created_at: DATETIME, default CURRENT_TIMESTAMP

### Table: appointments
- id: BIGINT, Primary Key, Auto Increment
- patient_id: BIGINT, Foreign Key → patients(id)
- doctor_id: BIGINT, Foreign Key → doctors(id)
- appointment_date: DATETIME, NOT NULL
- status: ENUM('pending','completed','cancelled'), default 'pending'
- created_at: DATETIME, default CURRENT_TIMESTAMP

### Table: clinic_locations
- id: BIGINT, Primary Key, Auto Increment
- name: VARCHAR(100), NOT NULL
- address: VARCHAR(255), NOT NULL
- city: VARCHAR(50), NOT NULL

### Table: payments
- id: BIGINT, Primary Key, Auto Increment
- appointment_id: BIGINT, Foreign Key → appointments(id)
- amount: DECIMAL(10,2), NOT NULL
- payment_date: DATETIME, default CURRENT_TIMESTAMP
- status: ENUM('pending','paid','failed'), default 'pending'

---

## MongoDB Collection Design

### Collection: prescriptions
```json
{
  "_id": "ObjectId('64abc123456')",
  "appointmentId": 51,
  "patientId": 12,
  "doctorId": 5,
  "medications": [
    {
      "name": "Paracetamol",
      "dosage": "500mg",
      "duration": "5 days"
    },
    {
      "name": "Amoxicillin",
      "dosage": "250mg",
      "duration": "7 days"
    }
  ],
  "doctorNotes": "Patient has mild fever, take medications as prescribed.",
  "refillCount": 1,
  "pharmacy": {
    "name": "Walgreens SF",
    "location": "Market Street"
  },
  "createdAt": "2025-12-12T15:00:00"
}
