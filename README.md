🏥 INDIA HOSPITAL – Hospital Management System

A full-stack Hospital Management System built using Java Spring Boot, React.js, and MySQL.

The project provides a simple web-based interface for managing doctors, patients, and appointments. The React frontend communicates with a Spring Boot REST API, which stores and retrieves data from a MySQL database.

🌐 Live Demo

Live Website:
https://hospital-management-system-neon-five.vercel.app

The frontend is deployed on Vercel, the Spring Boot backend is deployed on Render, and the MySQL database is hosted on Aiven.

📌 Features

👨‍⚕️ Doctor Management

View all doctors

Add a new doctor

Delete a doctor

Display doctor ID, name, and specialization

🧑‍🤝‍🧑 Patient Management

View patients

Patient records are created when an appointment is booked

Display patient ID, name, age, and gender

📅 Appointment Management

Book an appointment

Select a doctor

Store patient name, age, gender, doctor name, and appointment date

View all appointments

Delete an appointment

🏠 User Interface

Clean and simple React-based interface

Responsive layout

Navigation between Doctors, Patients, Appointments, and Home

Hospital-themed design

🛠️ Technologies Used

Frontend

React.js

JavaScript

HTML

CSS

Fetch API

Backend

Java

Spring Boot

Spring Web / REST API

JDBC

Maven

Database

MySQL

Aiven MySQL Cloud

Deployment

Vercel – Frontend

Render – Backend

Aiven – MySQL Database

GitHub – Source Code Repository

🏗️ Project Architecture

                    ┌──────────────────────┐
                    │      React.js        │
                    │      Frontend        │
                    │      (Vercel)        │
                    └──────────┬───────────┘
                               │
                               │ REST API
                               ▼
                    ┌──────────────────────┐
                    │    Spring Boot       │
                    │      Backend         │
                    │      (Render)         │
                    └──────────┬───────────┘
                               │
                               │ JDBC
                               ▼
                    ┌──────────────────────┐
                    │      MySQL           │
                    │      Database        │
                    │      (Aiven)         │
                    └──────────────────────┘

📂 Project Structure

Hospital-Management-System/
│
├── backend/
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── HospitalManagementsSystem/
│   │               ├── controller/
│   │               │   ├── AppointmentController.java
│   │               │   ├── DoctorController.java
│   │               │   └── PatientController.java
│   │               │
│   │               ├── database/
│   │               │   └── DatabaseConnection.java
│   │               │
│   │               ├── model/
│   │               │   ├── AppointmentModel.java
│   │               │   ├── DoctorModel.java
│   │               │   └── PatientModel.java
│   │               │
│   │               └── MainApplication.java
│   │
│   └── pom.xml
│
├── frontend/
│   ├── public/
│   ├── src/
│   │   ├── App.js
│   │   ├── App.css
│   │   ├── index.js
│   │   └── index.css
│   │
│   ├── package.json
│   └── package-lock.json
│
└── README.md

🔌 REST API Endpoints

Doctors

Method

Endpoint

Description

GET

/doctors

Get all doctors

POST

/addDoctor

Add a doctor

DELETE

/deleteDoctor/{id}

Delete a doctor

Patients

Method

Endpoint

Description

GET

/patients

Get all patients

DELETE

/deletePatient/{id}

Delete a patient

Appointments

Method

Endpoint

Description

GET

/appointments

Get all appointments

POST

/bookAppointment

Book an appointment

DELETE

/deleteAppointment/{id}

Delete an appointment

🗄️ Database

The application uses MySQL with the following main tables:

hospital database
│
├── doctors
├── patients
└── appointments

Doctors Table

id
name
specialization

Patients Table

id
name
age
gender

Appointments Table

id
patient_name
age
gender
doctor_name
appointment_date

⚙️ Database Configuration

The backend uses environment variables for database configuration instead of hard-coding database credentials.

The application expects:

DB_URL
DB_USERNAME
DB_PASSWORD

Example:

DB_URL=jdbc:mysql://your-host:your-port/defaultdb?ssl-mode=REQUIRED
DB_USERNAME=your-username
DB_PASSWORD=your-password

Never commit your real database username, password, or other private credentials to GitHub.

🚀 Run the Project Locally

1. Clone the Repository

git clone https://github.com/Piyush-Kushwah/Hospital-Management-System.git

cd Hospital-Management-System

2. Run the Backend

Open the backend folder in your Java IDE.

Make sure Java and Maven are installed.

Configure the required database environment variables:

DB_URL
DB_USERNAME
DB_PASSWORD

Then run:

MainApplication.java

The Spring Boot backend will normally start on:

http://localhost:8080

3. Run the Frontend

Open a terminal inside the frontend folder:

cd frontend

Install dependencies:

npm install

Start the React application:

npm start

The frontend will normally open at:

http://localhost:3000

🔄 How the Application Works

User
  │
  ▼
React Frontend
  │
  │ HTTP Request
  ▼
Spring Boot REST Controller
  │
  │ JDBC
  ▼
MySQL Database
  │
  │ Query Result
  ▼
Spring Boot
  │
  │ JSON Response
  ▼
React Frontend
  │
  ▼
User Interface

Example: Viewing Doctors

User clicks View Doctors.

React sends a GET request to /doctors.

Spring Boot receives the request.

DoctorController queries the doctors table.

Database results are converted into DoctorModel objects.

Spring Boot returns the doctors as JSON.

React displays the doctors on the webpage.

📸 Application

The application provides a hospital dashboard with options such as:

1. View Doctors
2. View Patients
3. Book Appointment
4. View Appointments
5. Home

🔐 Security Note

Database credentials are loaded using environment variables:

System.getenv("DB_URL");
System.getenv("DB_USERNAME");
System.getenv("DB_PASSWORD");

This keeps sensitive database credentials outside the source code.

Do not upload passwords, API keys, or private credentials to GitHub.

🎯 Learning Objectives

This project demonstrates practical use of:

Java programming

Spring Boot

REST APIs

JDBC

MySQL

React.js

JavaScript

CRUD operations

Frontend-backend integration

Database connectivity

Environment variables

Git and GitHub

Cloud deployment

👨‍💻 Author

Piyush Kushwah

GitHub:
https://github.com/Piyush-Kushwah

⭐ Project Status

Completed and Deployed

The application is currently deployed and connected to a cloud MySQL database.

If you find this project useful, consider giving the repository a ⭐ on GitHub.
