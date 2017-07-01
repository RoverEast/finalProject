package com.epam.models;

public class Sick {
    private long id;
    private String name;

    public Sick(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Sick() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sick sick = (Sick) o;

        return id == sick.id && (name != null ? name.equals(sick.name) : sick.name == null);
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return (int) result;
    }

    @Override
    public String toString() {
        return "Sick{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
