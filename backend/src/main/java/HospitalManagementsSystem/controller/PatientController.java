package HospitalManagementsSystem.controller;

import HospitalManagementsSystem.database.DatabaseConnection;
import HospitalManagementsSystem.model.PatientModel;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class PatientController {

    // ================= GET PATIENTS =================

    @GetMapping("/patients")
    public List<PatientModel> getPatients() {

        List<PatientModel> patients = new ArrayList<>();

        try {

            Connection connection =
                    DatabaseConnection.getConnection();

            String query = "SELECT * FROM patients";

            Statement statement =
                    connection.createStatement();

            ResultSet resultSet =
                    statement.executeQuery(query);

            while (resultSet.next()) {

                PatientModel patient =
                        new PatientModel(

                                resultSet.getInt("id"),

                                resultSet.getString("name"),

                                resultSet.getInt("age"),

                                resultSet.getString("gender")
                        );

                patients.add(patient);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return patients;
    }


    // ================= DELETE PATIENT =================

    @DeleteMapping("/deletePatient/{id}")
    public String deletePatient(
            @PathVariable int id
    ) {

        try {

            Connection connection =
                    DatabaseConnection.getConnection();

            String query =
                    "DELETE FROM patients WHERE id=?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            int rowsDeleted =
                    preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {

                return "Patient Deleted Successfully";

            } else {

                return "Patient Not Found";
            }

        } catch (Exception e) {

            e.printStackTrace();

            return "Error Deleting Patient";
        }
    }
}