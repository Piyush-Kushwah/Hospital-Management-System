import React, { useEffect, useState } from "react";
import "./App.css";
const API_URL = "https://hospital-management-system1-hmqn.onrender.com";

function App() {

  const [page, setPage] = useState("home");

  const [doctors, setDoctors] = useState([]);

  const [patients, setPatients] = useState([]);

  const [appointments, setAppointments] = useState([]);

  const [doctorName, setDoctorName] = useState("");

  const [specialization, setSpecialization] =
    useState("");

  const [patientName, setPatientName] =
    useState("");

  const [age, setAge] = useState("");

  const [gender, setGender] = useState("");

  const [selectedDoctor, setSelectedDoctor] =
    useState("");

  const [appointmentDate, setAppointmentDate] =
    useState("");



  useEffect(() => {

    if (page === "doctors") {
        fetchDoctors();
    }

    if (page === "patients") {
        fetchPatients();
    }

    if (page === "appointments") {
        fetchAppointments();
    }

    if (page === "appointment") {
        fetchDoctors();
    }

}, [page]);




  // ================= FETCH DOCTORS =================

  const fetchDoctors = async () => {

    try {

        const response = await fetch(
            `${API_URL}/doctors`
        );

        if (!response.ok) {
            throw new Error(
                `Server error: ${response.status}`
            );
        }

        const data = await response.json();

        console.log("Doctors received:", data);

        setDoctors(data);

    } catch (error) {

        console.error("Error fetching doctors:", error);

        alert("Unable to load doctors. Please try again.");
    }
};




  // ================= FETCH PATIENTS =================

  const fetchPatients = async () => {

    const response = await fetch(
      `${API_URL}/patients`
    );

    const data = await response.json();

    setPatients(data);
  };




  // ================= FETCH APPOINTMENTS =================

  const fetchAppointments = async () => {

    const response = await fetch(
      `${API_URL}/appointments`
    );

    const data = await response.json();

    setAppointments(data);
  };




  // ================= ADD DOCTOR =================

  const addDoctor = async () => {

    if (!doctorName || !specialization) {

      alert("Fill all fields");

      return;
    }

    await fetch(
      `${API_URL}/addDoctor`,
      {
        method: "POST",

        headers: {
          "Content-Type": "application/json"
        },

        body: JSON.stringify({

          name: doctorName,

          specialization: specialization
        })
      }
    );

    setDoctorName("");

    setSpecialization("");

    fetchDoctors();
  };




  // ================= DELETE DOCTOR =================

  const deleteDoctor = async (id) => {

    await fetch(
      `${API_URL}/deleteDoctor/${id}`,
      {
        method: "DELETE"
      }
    );

    fetchDoctors();
  };




  // ================= BOOK APPOINTMENT =================

  const bookAppointment = async () => {

    if (
      !patientName ||
      !age ||
      !gender ||
      !selectedDoctor ||
      !appointmentDate
    ) {

      alert("Fill all fields");

      return;
    }

    await fetch(
      `${API_URL}/bookAppointment`,
      {
        method: "POST",

        headers: {
          "Content-Type": "application/json"
        },

        body: JSON.stringify({

          patientName: patientName,

          age: age,

          gender: gender,

          doctorName: selectedDoctor,

          appointmentDate: appointmentDate
        })
      }
    );

    setPatientName("");

    setAge("");

    setGender("");

    setSelectedDoctor("");

    setAppointmentDate("");

    fetchAppointments();

    fetchPatients();

    alert("Appointment Booked Successfully");
  };




  // ================= DELETE APPOINTMENT =================

  const deleteAppointment = async (id) => {

    await fetch(
      `${API_URL}/deleteAppointment/${id}`,
      {
        method: "DELETE"
      }
    );

    fetchAppointments();

    fetchPatients();
  };




  return (

    <div className="container">

      <div className="header">

        <h1 className="main-heading">
          INDIA HOSPITAL
        </h1>

        <p className="sub-heading">
          Hospital Management System
        </p>

      </div>




      <div className="buttons">

        <button
          onClick={() => setPage("doctors")}
        >
          1. View Doctors
        </button>

        <button
          onClick={() => setPage("patients")}
        >
          2. View Patients
        </button>

        <button
          onClick={() => setPage("appointment")}
        >
          3. Book Appointment
        </button>

        <button
          onClick={() => setPage("appointments")}
        >
          4. View Appointments
        </button>

      </div>




      <div className="buttons">

        <button
          onClick={() => setPage("home")}
        >
          5. Home
        </button>

      </div>




      {page === "home" && (

        <h1 className="section-title">
          Choose Your Option
        </h1>

      )}




      {/* ================= DOCTORS ================= */}

      {page === "doctors" && (

        <>

          <h1 className="section-title">
            Doctors
          </h1>

          <div className="appointment-form">

            <input
              type="text"
              placeholder="Doctor Name"
              value={doctorName}
              onChange={(e) =>
                setDoctorName(e.target.value)
              }
            />

            <input
              type="text"
              placeholder="Specialization"
              value={specialization}
              onChange={(e) =>
                setSpecialization(e.target.value)
              }
            />

            <button
              className="book-btn"
              onClick={addDoctor}
            >
              Add Doctor
            </button>

          </div>




          <table className="table">

            <thead>

              <tr>

                <th>ID</th>

                <th>Name</th>

                <th>Specialization</th>

                <th>Action</th>

              </tr>

            </thead>

            <tbody>

              {doctors.map((doctor) => (

                <tr key={doctor.id}>

                  <td>{doctor.id}</td>

                  <td>{doctor.name}</td>

                  <td>
                    {doctor.specialization}
                  </td>

                  <td>

                    <button
                      className="delete-btn"
                      onClick={() =>
                        deleteDoctor(doctor.id)
                      }
                    >
                      Delete
                    </button>

                  </td>

                </tr>

              ))}

            </tbody>

          </table>

        </>

      )}




      {/* ================= PATIENTS ================= */}

      {page === "patients" && (

        <>

          <h1 className="section-title">
            Patients
          </h1>

          <table className="table">

            <thead>

              <tr>

                <th>ID</th>

                <th>Patient Name</th>

                <th>Age</th>

                <th>Gender</th>

              </tr>

            </thead>

            <tbody>

              {patients.map((patient) => (

                <tr key={patient.id}>

                  <td>{patient.id}</td>

                  <td>{patient.name}</td>

                  <td>{patient.age}</td>

                  <td>{patient.gender}</td>

                </tr>

              ))}

            </tbody>

          </table>

        </>

      )}




      {/* ================= BOOK APPOINTMENT ================= */}

      {page === "appointment" && (

        <>

          <h1 className="section-title">
            Book Appointment
          </h1>

          <div className="appointment-form">

            <input
              type="text"
              placeholder="Patient Name"
              value={patientName}
              onChange={(e) =>
                setPatientName(e.target.value)
              }
            />

            <input
              type="number"
              placeholder="Patient Age"
              value={age}
              onChange={(e) =>
                setAge(e.target.value)
              }
            />

            <select
              value={gender}
              onChange={(e) =>
                setGender(e.target.value)
              }
            >

              <option value="">
                Select Gender
              </option>

              <option value="Male">
                Male
              </option>

              <option value="Female">
                Female
              </option>

            </select>




            <select
              value={selectedDoctor}
              onChange={(e) =>
                setSelectedDoctor(
                  e.target.value
                )
              }
            >

              <option value="">
                Select Doctor
              </option>

              {doctors.map((doctor) => (

                <option
                  key={doctor.id}
                  value={doctor.name}
                >
                  {doctor.name} - {doctor.specialization}
                </option>

              ))}

            </select>




            <input
              type="date"
              value={appointmentDate}
              onChange={(e) =>
                setAppointmentDate(
                  e.target.value
                )
              }
            />




            <button
              className="book-btn"
              onClick={bookAppointment}
            >
              Book Appointment
            </button>

          </div>

        </>

      )}




      {/* ================= APPOINTMENTS ================= */}

      {page === "appointments" && (

        <>

          <h1 className="section-title">
            Appointments
          </h1>

          <table className="table">

            <thead>

              <tr>

                <th>ID</th>

                <th>Patient Name</th>

                <th>Age</th>

                <th>Gender</th>

                <th>Doctor</th>

                <th>Date</th>

                <th>Action</th>

              </tr>

            </thead>

            <tbody>

              {appointments.map((appointment) => (

                <tr key={appointment.id}>

                  <td>{appointment.id}</td>

                  <td>
                    {appointment.patientName}
                  </td>

                  <td>{appointment.age}</td>

                  <td>
                    {appointment.gender}
                  </td>

                  <td>
                    {appointment.doctorName}
                  </td>

                  <td>
                    {appointment.appointmentDate}
                  </td>

                  <td>

                    <button
                      className="delete-btn"
                      onClick={() =>
                        deleteAppointment(
                          appointment.id
                        )
                      }
                    >
                      Delete
                    </button>

                  </td>

                </tr>

              ))}

            </tbody>

          </table>

        </>

      )}

    </div>
  );
}

export default App;