package com.epam.models;

public class Patient {

    private long id;
    private long idSick;
    private long idMixture;
    private long idOperations;
    private long user_ID;
    private long idProcedure;

    public Patient(long idSisck, long idMixture, long idOperations, long idProcedure, long user_ID) {
        this.idSick = idSisck;
        this.idMixture = idMixture;
        this.idOperations = idOperations;
        this.user_ID = user_ID;
        this.idProcedure = idProcedure;
    }

    public Patient(int id, int idSick, int idMixture, int idOperations, long idProcedure, int user_ID) {
        this.id = id;
        this.idSick = idSick;
        this.idMixture = idMixture;
        this.idOperations = idOperations;
        this.user_ID = user_ID;
        this.idProcedure = idProcedure;
    }

    public Patient() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdSick() {
        return idSick;
    }

    public void setIdSick(long idSick) {
        this.idSick = idSick;
    }

    public long getIdMixture() {
        return idMixture;
    }

    public void setIdMixture(long idMixture) {
        this.idMixture = idMixture;
    }

    public long getIdOperations() {
        return idOperations;
    }

    public void setIdOperations(long idOperations) {
        this.idOperations = idOperations;
    }

    public long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(long user_ID) {
        this.user_ID = user_ID;
    }

    public long getIdProcedure() {
        return idProcedure;
    }

    public void setIdProcedure(long idProcedure) {
        this.idProcedure = idProcedure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (id != patient.id) return false;
        if (idSick != patient.idSick) return false;
        if (idMixture != patient.idMixture) return false;
        if (idOperations != patient.idOperations) return false;
        return user_ID == patient.user_ID && idProcedure == patient.idProcedure;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idSick ^ (idSick >>> 32));
        result = 31 * result + (int) (idMixture ^ (idMixture >>> 32));
        result = 31 * result + (int) (idOperations ^ (idOperations >>> 32));
        result = 31 * result + (int) (user_ID ^ (user_ID >>> 32));
        result = 31 * result + (int) (idProcedure ^ (idProcedure >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", idSick=" + idSick +
                ", idMixture=" + idMixture +
                ", idOperations=" + idOperations +
                ", user_ID=" + user_ID +
                ", idProcedure=" + idProcedure +
                '}';
    }
}
