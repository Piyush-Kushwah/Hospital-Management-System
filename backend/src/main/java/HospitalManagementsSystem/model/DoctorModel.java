package HospitalManagementsSystem.model;

public class DoctorModel {

    private int id;

    private String name;

    private String specialization;

    public DoctorModel() {
    }

    public DoctorModel(
            int id,
            String name,
            String specialization
    ) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}