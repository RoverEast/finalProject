package com.epam.models;

public class Personal {
    private long id;
    private long patient_id;
    private int user_id;

    public Personal(int id, int patient_id, int user_id) {
        this.id = id;
        this.patient_id = patient_id;
        this.user_id = user_id;
    }

    public Personal(long patient_id, int user_id) {
        this.patient_id = patient_id;
        this.user_id = user_id;
    }

    public Personal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personal personal = (Personal) o;

        if (id != personal.id) return false;
        return patient_id == personal.patient_id && user_id == personal.user_id;
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + patient_id;
        result = 31 * result + user_id;
        return (int) result;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "id=" + id +
                ", patient_id=" + patient_id +
                ", user_id=" + user_id +
                '}';
    }
}
