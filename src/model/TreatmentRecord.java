package model;

public class TreatmentRecord {
    private int patientId;
    private String patientName;
    private String treatmentGiven;
    private String completionTime;

    public TreatmentRecord(int patientId, String patientName, String treatmentGiven, String completionTime) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentGiven = treatmentGiven;
        this.completionTime = completionTime;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTreatmentGiven() {
        return treatmentGiven;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
               " | Name: " + patientName +
               " | Treatment: " + treatmentGiven +
               " | Completed At: " + completionTime;
    }
}