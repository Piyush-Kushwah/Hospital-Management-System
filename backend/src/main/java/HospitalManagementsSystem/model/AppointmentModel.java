package HospitalManagementsSystem.model;

public class AppointmentModel {

    private int id;

    private String patientName;

    private int age;

    private String gender;

    private String doctorName;

    private String appointmentDate;



    // EMPTY CONSTRUCTOR

    public AppointmentModel() {

    }



    // FULL CONSTRUCTOR

    public AppointmentModel(

            int id,

            String patientName,

            int age,

            String gender,

            String doctorName,

            String appointmentDate
    ) {

        this.id = id;

        this.patientName = patientName;

        this.age = age;

        this.gender = gender;

        this.doctorName = doctorName;

        this.appointmentDate = appointmentDate;
    }



    // ================= GETTERS =================

    public int getId() {

        return id;
    }



    public String getPatientName() {

        return patientName;
    }



    public int getAge() {

        return age;
    }



    public String getGender() {

        return gender;
    }



    public String getDoctorName() {

        return doctorName;
    }



    public String getAppointmentDate() {

        return appointmentDate;
    }



    // ================= SETTERS =================

    public void setId(int id) {

        this.id = id;
    }



    public void setPatientName(String patientName) {

        this.patientName = patientName;
    }



    public void setAge(int age) {

        this.age = age;
    }



    public void setGender(String gender) {

        this.gender = gender;
    }



    public void setDoctorName(String doctorName) {

        this.doctorName = doctorName;
    }



    public void setAppointmentDate(String appointmentDate) {

        this.appointmentDate = appointmentDate;
    }
}