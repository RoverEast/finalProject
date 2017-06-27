package com.epam.models;

import java.sql.Date;

/**
 * Created by Администратор on 22.05.2017.
 */
public class User {
    private long id ;
    private String userName;
    private String password;
    private Position position;
    private String firstName;
    private String secondName;
    private String midletName;
    private Date birtDate;

    public User(long id, String userName, String password, Position position, String firstName, String secondName, String midletName, Date birtDate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.position = position;
        this.firstName = firstName;
        this.secondName = secondName;
        this.midletName = midletName;
        this.birtDate = birtDate;
    }

    public User(String userName, String password, Position position, String firstName, String secondName, String midletName, Date birtDate) {
        this.userName = userName;
        this.password = password;
        this.position = position;
        this.firstName = firstName;
        this.secondName = secondName;
        this.midletName = midletName;
        this.birtDate = birtDate;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String lasttName) {
        this.secondName = lasttName;
    }

    public String getMidletName() {
        return midletName;
    }

    public void setMidletName(String midletName) {
        this.midletName = midletName;
    }

    public Date getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(Date birtDate) {
        this.birtDate = birtDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (position != user.position) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (secondName != null ? !secondName.equals(user.secondName) : user.secondName != null) return false;
        if (midletName != null ? !midletName.equals(user.midletName) : user.midletName != null) return false;
        return birtDate != null ? birtDate.equals(user.birtDate) : user.birtDate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + position.ordinal();
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (midletName != null ? midletName.hashCode() : 0);
        result = 31 * result + (birtDate != null ? birtDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", position=" + position +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", midletName='" + midletName + '\'' +
                ", birtDate=" + birtDate +
                '}';
    }

    //////тут все параметры таблицы юзер

}
