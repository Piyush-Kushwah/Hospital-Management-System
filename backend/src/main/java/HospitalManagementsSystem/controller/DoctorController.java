package HospitalManagementsSystem.controller;

import HospitalManagementsSystem.database.DatabaseConnection;
import HospitalManagementsSystem.model.DoctorModel;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.List;

@RestController

@CrossOrigin("*")

public class DoctorController {

    @GetMapping("/doctors")

    public List<DoctorModel> getDoctors() {

        List<DoctorModel> doctors =
                new ArrayList<>();

        try {

            Connection connection =
                    DatabaseConnection.getConnection();

            String query =
                    "SELECT * FROM doctors";

            Statement statement =
                    connection.createStatement();

            ResultSet resultSet =
                    statement.executeQuery(query);

            while(resultSet.next()) {

                DoctorModel doctor =
                        new DoctorModel(

                                resultSet.getInt("id"),

                                resultSet.getString("name"),

                                resultSet.getString("specialization")
                        );

                doctors.add(doctor);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return doctors;
    }



    @PostMapping("/addDoctor")

    public String addDoctor(
            @RequestBody DoctorModel doctor
    ) {

        try {

            Connection connection =
                    DatabaseConnection.getConnection();

            String query =
                    "INSERT INTO doctors(name,specialization) VALUES(?,?)";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setString(
                    1,
                    doctor.getName()
            );

            preparedStatement.setString(
                    2,
                    doctor.getSpecialization()
            );

            preparedStatement.executeUpdate();

            return "Doctor Added Successfully";

        } catch (Exception e) {

            e.printStackTrace();

            return "Error Adding Doctor";
        }
    }



    @DeleteMapping("/deleteDoctor/{id}")

    public String deleteDoctor(
            @PathVariable int id
    ) {

        try {

            Connection connection =
                    DatabaseConnection.getConnection();

            String query =
                    "DELETE FROM doctors WHERE id=?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();

            return "Doctor Deleted";

        } catch (Exception e) {

            e.printStackTrace();

            return "Error Deleting Doctor";
        }
    }
}