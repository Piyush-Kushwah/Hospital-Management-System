package HospitalManagementsSystem.model;

public class PatientModel {

    private int id;

    private String name;

    private int age;

    private String gender;

    public PatientModel() {
    }

    public PatientModel(
            int id,
            String name,
            int age,
            String gender
    ) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}