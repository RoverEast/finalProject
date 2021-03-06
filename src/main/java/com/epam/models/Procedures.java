package com.epam.models;


public class Procedures {

    private long id;
    private String name;

    public Procedures(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Procedures(String name) {
        this.name = name;
    }

    public Procedures() {
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

        Procedures that = (Procedures) o;

        return id == that.id && (name != null ? name.equals(that.name) : that.name == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Procedures{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
