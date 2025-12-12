-- Admins
INSERT INTO admin (username, password, email) VALUES
    ('admin1','password123','admin1@clinic.com');

-- Doctors
INSERT INTO doctors (name,email,specialty,password) VALUES
    ('Dr. John Doe','johndoe@clinic.com','Cardiology','pass123');

-- Patients
INSERT INTO patients (name,email,phone) VALUES
    ('Patient One','patient1@email.com','03001234567');

-- Appointments
INSERT INTO appointments (patient_id, doctor_id, appointment_date,status) VALUES
    (1,1,'2025-12-20 10:00:00','pending');
