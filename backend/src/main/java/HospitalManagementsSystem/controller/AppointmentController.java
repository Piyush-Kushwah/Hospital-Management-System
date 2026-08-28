package HospitalManagementsSystem.controller;

import HospitalManagementsSystem.database.DatabaseConnection;
import HospitalManagementsSystem.model.AppointmentModel;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

@RestController

@CrossOrigin("*")

public class AppointmentController {



    // ================= GET APPOINTMENTS =================

    @GetMapping("/appointments")

    public List<AppointmentModel> getAppointments() {

        List<AppointmentModel> appointments =
                new ArrayList<>();

        try {

            Connection connection =
                    DatabaseConnection.getConnection();

            String query =
                    "SELECT * FROM appointments";

            Statement statement =
                    connection.createStatement();

            ResultSet resultSet =
                    statement.executeQuery(query);

            while(resultSet.next()) {

                AppointmentModel appointment =
                        new AppointmentModel(

                                resultSet.getInt("id"),

                                resultSet.getString("patient_name"),

                                resultSet.getInt("age"),

                                resultSet.getString("gender"),

                                resultSet.getString("doctor_name"),

                                resultSet.getString("appointment_date")
                        );

                appointments.add(appointment);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return appointments;
    }





    // ================= BOOK APPOINTMENT =================

    @PostMapping("/bookAppointment")

    public String bookAppointment(
            @RequestBody AppointmentModel appointment
    ) {

        try {

            Connection connection =
                    DatabaseConnection.getConnection();




            // ===== SAVE IN APPOINTMENTS =====

            String appointmentQuery =
                    "INSERT INTO appointments(patient_name,age,gender,doctor_name,appointment_date) VALUES(?,?,?,?,?)";

            PreparedStatement appointmentStatement =
                    connection.prepareStatement(appointmentQuery);

            appointmentStatement.setString(
                    1,
                    appointment.getPatientName()
            );

            appointmentStatement.setInt(
                    2,
                    appointment.getAge()
            );

            appointmentStatement.setString(
                    3,
                    appointment.getGender()
            );

            appointmentStatement.setString(
                    4,
                    appointment.getDoctorName()
            );

            appointmentStatement.setString(
                    5,
                    appointment.getAppointmentDate()
            );

            appointmentStatement.executeUpdate();




            // ===== SAVE IN PATIENTS =====

            String patientQuery =
                    "INSERT INTO patients(name,age,gender) VALUES(?,?,?)";

            PreparedStatement patientStatement =
                    connection.prepareStatement(patientQuery);

            patientStatement.setString(
                    1,
                    appointment.getPatientName()
            );

            patientStatement.setInt(
                    2,
                    appointment.getAge()
            );

            patientStatement.setString(
                    3,
                    appointment.getGender()
            );

            patientStatement.executeUpdate();




            return "Appointment Booked Successfully";

        } catch (Exception e) {

            e.printStackTrace();

            return "Error Booking Appointment";
        }
    }





    // ================= DELETE APPOINTMENT =================

    @DeleteMapping("/deleteAppointment/{id}")

    public String deleteAppointment(
            @PathVariable int id
    ) {

        try {

            Connection connection =
                    DatabaseConnection.getConnection();




            // ===== GET PATIENT NAME =====

            String getPatientQuery =
                    "SELECT patient_name FROM appointments WHERE id=?";

            PreparedStatement getPatientStatement =
                    connection.prepareStatement(getPatientQuery);

            getPatientStatement.setInt(1,id);

            ResultSet resultSet =
                    getPatientStatement.executeQuery();

            String patientName = "";

            if(resultSet.next()) {

                patientName =
                        resultSet.getString("patient_name");
            }




            // ===== DELETE APPOINTMENT =====

            String deleteAppointmentQuery =
                    "DELETE FROM appointments WHERE id=?";

            PreparedStatement deleteAppointmentStatement =
                    connection.prepareStatement(deleteAppointmentQuery);

            deleteAppointmentStatement.setInt(1,id);

            deleteAppointmentStatement.executeUpdate();




            // ===== DELETE PATIENT =====

            String deletePatientQuery =
                    "DELETE FROM patients WHERE name=?";

            PreparedStatement deletePatientStatement =
                    connection.prepareStatement(deletePatientQuery);

            deletePatientStatement.setString(
                    1,
                    patientName
            );

            deletePatientStatement.executeUpdate();




            return "Appointment Deleted";

        } catch (Exception e) {

            e.printStackTrace();

            return "Error Deleting Appointment";
        }
    }
}