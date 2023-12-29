package com.example.cantien.systemadmin;



/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class User {
    protected int id;
    protected String uname;
    protected String email;
    protected String department;

    public User() {
    }

    public User(String uname, String email, String department) {
        super();
        this.uname = uname;
        this.email = email;
        this.department = department;
    }

    public User(int id, String uname, String email, String department) {
        super();
        this.id = id;
        this.uname = uname;
        this.email = email;
        this.department = department;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
