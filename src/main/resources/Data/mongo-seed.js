use SmartClinicManagement;

db.prescriptions.insertMany([
    {
        "patientId": 1,
        "appointmentId": 1,
        "medication": "Paracetamol",
        "dosage": "500mg",
        "doctorNotes": "Take 1 tablet every 6 hours",
        "refillCount": 2,
        "pharmacy": { "name": "Walgreens SF", "location": "Market Street" },
        "createdAt": new Date()
    },
    {
        "patientId": 2,
        "appointmentId": 2,
        "medication": "Ibuprofen",
        "dosage": "400mg",
        "doctorNotes": "Take 1 tablet every 8 hours",
        "refillCount": 1,
        "pharmacy": { "name": "CVS NY", "location": "5th Avenue" },
        "createdAt": new Date()
    },
    {
        "patientId": 3,
        "appointmentId": 3,
        "medication": "Amoxicillin",
        "dosage": "250mg",
        "doctorNotes": "Take 1 tablet every 12 hours",
        "refillCount": 0,
        "pharmacy": { "name": "Rite Aid LA", "location": "Sunset Blvd" },
        "createdAt": new Date()
    }
]);
