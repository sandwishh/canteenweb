package com.example.cantien.login;


import java.sql.*;

public class LoginDao {
    private String dbUrl="jdbc:mysql://localhost:3306/user";
    private String dbUname="root";
    private String dbPassword="root1234";
    private String dbDriver="com.mysql.cj.jdbc.Driver";

    public void loadDriver(String dbDriver){
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        Connection con=null;
        try {
            con= DriverManager.getConnection(dbUrl,dbUname,dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public boolean validate(LoginBean loginBean) {
        loadDriver(dbDriver);
        Connection con=getConnection();
        boolean status=false;
        String sql="select * from member where uname = ? and password=? and department=?";

        PreparedStatement ps;
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, loginBean.getUname());
            ps.setString(2, loginBean.getPassword());
            ps.setString(3, loginBean.getDepartment());


            ResultSet rs=ps.executeQuery();
            status=rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
