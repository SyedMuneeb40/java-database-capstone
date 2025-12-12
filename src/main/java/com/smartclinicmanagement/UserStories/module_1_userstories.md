# Smart Clinic Management System - User Stories

## Module 1: Admin User Stories

### User Story 1
**Title:**
_As an Admin, I want to log into the portal with my username and password, so that I can manage the platform securely._

**Acceptance Criteria:**
1. Admin can enter username and password on login page.
2. Successful login redirects admin to dashboard.
3. Invalid credentials show an error message.

**Priority:** High
**Story Points:** 3
**Notes:**
- Login attempts should be limited to prevent brute-force attacks.

### User Story 2
**Title:**
_As an Admin, I want to log out of the portal, so that I can protect system access when I am done._

**Acceptance Criteria:**
1. Admin can click a logout button.
2. Session is invalidated on logout.
3. Redirect to login page after logout.

**Priority:** High
**Story Points:** 2
**Notes:**
- Logout button should be visible on every page after login.

### User Story 3
**Title:**
_As an Admin, I want to add doctors to the portal, so that they can manage appointments and patient records._

**Acceptance Criteria:**
1. Admin can access “Add Doctor” form from dashboard.
2. Required fields: Name, Email, Specialty, Password.
3. Validation for email format and required fields.
4. Successful submission adds doctor to database.

**Priority:** High
**Story Points:** 5
**Notes:**
- Automatically send an email notification to the doctor after registration.

### User Story 4
**Title:**
_As an Admin, I want to delete a doctor’s profile from the portal, so that outdated or incorrect accounts can be removed._

**Acceptance Criteria:**
1. Admin can see a list of all doctors.
2. Admin can select a doctor and click “Delete”.
3. Confirmation popup appears before deletion.
4. Doctor is removed from database and cannot log in.

**Priority:** Medium
**Story Points:** 3
**Notes:**
- Deleting a doctor should also remove associated appointments if required.

### User Story 5
**Title:**
_As an Admin, I want to run a stored procedure in MySQL to get the number of appointments per month, so that I can track usage statistics._

**Acceptance Criteria:**
1. Admin can execute stored procedure from portal or MySQL CLI.
2. Procedure returns month-wise appointment counts.
3. Admin can view or export the results.

**Priority:** Medium
**Story Points:** 4
**Notes:**
- Stored procedure should handle months with zero appointments gracefully.

---

## Module 1: Doctor User Stories

### User Story 1
**Title:**
_As a Doctor, I want to view my daily appointments, so that I can plan my schedule._

**Acceptance Criteria:**
1. Doctor can see all appointments for the current day.
2. Appointments display patient name, time, and reason.
3. Doctor can mark appointment as completed.

**Priority:** High
**Story Points:** 3
**Notes:**
- Appointments should refresh automatically or on page reload.

### User Story 2
**Title:**
_As a Doctor, I want to update patient medical records, so that accurate information is maintained._

**Acceptance Criteria:**
1. Doctor can select a patient from appointments.
2. Doctor can add notes, diagnosis, or treatment plan.
3. Changes are saved in database securely.

**Priority:** High
**Story Points:** 5
**Notes:**
- Only assigned doctor can update patient record.

### User Story 3
**Title:**
_As a Doctor, I want to add prescriptions for patients, so that treatment instructions are available._

**Acceptance Criteria:**
1. Doctor can create a prescription with medication, dosage, and duration.
2. Prescription is linked to the patient’s medical history.
3. Prescription can be viewed by the patient.

**Priority:** Medium
**Story Points:** 4
**Notes:**
- Prescriptions stored in MongoDB for flexible schema.

### User Story 4
**Title:**
_As a Doctor, I want to view a patient’s medical history, so that I can make informed treatment decisions._

**Acceptance Criteria:**
1. Doctor can search patient by name or ID.
2. Past visits, prescriptions, and diagnoses are displayed.
3. Sensitive data access is logged for security.

**Priority:** High
**Story Points:** 3
**Notes:**
- History should be read-only to prevent accidental edits.

### User Story 5
**Title:**
_As a Doctor, I want to see upcoming appointments, so that I can prepare in advance._

**Acceptance Criteria:**
1. Doctor dashboard shows next 7 days of appointments.
2. Notifications for new bookings or cancellations.
3. Doctor can filter appointments by date.

**Priority:** Medium
**Story Points:** 3
**Notes:**
- Allow sorting by time or patient name.

---

## Module 1: Patient User Stories

### User Story 1
**Title:**
_As a Patient, I want to register an account, so that I can book appointments._

**Acceptance Criteria:**
1. Patient can fill registration form with name, email, password, and phone.
2. Email is validated for proper format.
3. Account is saved in MySQL database.

**Priority:** High
**Story Points:** 3
**Notes:**
- Passwords should be hashed.

### User Story 2
**Title:**
_As a Patient, I want to book appointments, so that I can schedule visits with doctors._

**Acceptance Criteria:**
1. Patient can select doctor, date, and time slot.
2. System checks availability before confirming.
3. Confirmation notification sent to patient.

**Priority:** High
**Story Points:** 4
**Notes:**
- Prevent double-booking of same time slot.

### User Story 3
**Title:**
_As a Patient, I want to view my booked appointments, so that I can manage my visits._

**Acceptance Criteria:**
1. Patient dashboard lists all upcoming appointments.
2. Can cancel or reschedule if allowed by policy.
3. Displays doctor’s name, time, and reason.

**Priority:** Medium
**Story Points:** 3
**Notes:**
- Cancelled slots should free up availability.

### User Story 4
**Title:**
_As a Patient, I want to see my medical history online, so that I can track past treatments._

**Acceptance Criteria:**
1. Patient can view previous visits, diagnoses, and prescriptions.
2. Only patient can access their own records.
3. Records displayed in readable format.

**Priority:** Medium
**Story Points:** 3
**Notes:**
- History pulled from MySQL and MongoDB as needed.

### User Story 5
**Title:**
_As a Patient, I want to receive notifications for upcoming appointments, so that I don’t miss my visits._

**Acceptance Criteria:**
1. Email or portal notifications 24 hours before appointment.
2. Notifications update if appointment is rescheduled or canceled.
3. Patient can mark notification as read.

**Priority:** Low
**Story Points:** 2
**Notes:**
- Notification system should be extensible for future SMS alerts.

