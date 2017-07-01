package com.epam.models;

public class Mixtures {
    private long id;
    private String name;

    public Mixtures(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Mixtures() {
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

        Mixtures mixtures = (Mixtures) o;

        return id == mixtures.id && (name != null ? name.equals(mixtures.name) : mixtures.name == null);
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return (int) result;
    }

    @Override
    public String toString() {
        return "Mixtures{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
