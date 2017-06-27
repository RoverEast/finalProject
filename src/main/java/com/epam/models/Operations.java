package com.epam.models;

/**
 * Created by Администратор on 22.05.2017.
 */
public class Operations {
    private long id;
    private String name;

    public Operations(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Operations() {
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

        Operations that = (Operations) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return (int) result;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
