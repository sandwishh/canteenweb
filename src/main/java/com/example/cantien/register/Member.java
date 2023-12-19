package com.example.cantien.register;

public class Member {
    private String uname,email,password,department;

    public Member() {
        super();
    }

    public Member(String uname, String email, String password, String department) {
        this.uname = uname;
        this.email = email;
        this.password = password;
        this.department = department;
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

    public void setDepartment(String phone) {
        this.department = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }


}
