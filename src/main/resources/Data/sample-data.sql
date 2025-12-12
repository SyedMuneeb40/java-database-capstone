USE cms;

-- Admin
INSERT INTO admin (id, username, password, email) VALUES
    (1, 'admin1', 'adminpass', 'admin1@clinic.com');

-- Doctors
INSERT INTO doctor (id, name, email, specialty, password) VALUES
                                                              (1, 'Dr. Alice', 'alice@clinic.com', 'Cardiology', 'password1'),
                                                              (2, 'Dr. Bob', 'bob@clinic.com', 'Dermatology', 'password2'),
                                                              (3, 'Dr. Charlie', 'charlie@clinic.com', 'Neurology', 'password3');

-- Patients
INSERT INTO patient (id, name, email, phone) VALUES
                                                 (1, 'John Smith', 'john@gmail.com', '1234567890'),
                                                 (2, 'Emma Watson', 'emma@gmail.com', '0987654321'),
                                                 (3, 'Michael Brown', 'michael@gmail.com', '1112223333');

-- Appointments
INSERT INTO appointment (id, doctor_id, patient_id, appointment_time, status) VALUES
                                                                                  (1, 1, 1, '2025-12-15 10:00:00', 0),
                                                                                  (2, 2, 2, '2025-12-16 11:30:00', 0),
                                                                                  (3, 3, 3, '2025-12-17 09:00:00', 0);
