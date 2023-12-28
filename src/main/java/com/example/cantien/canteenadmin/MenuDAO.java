package com.example.cantien.canteenadmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.cantien.canteenadmin.Menu;
public class MenuDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/user?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root1234";

    private static final String INSERT_USERS_SQL = "INSERT INTO menu" + "  (dname, price, category,photo) VALUES "
            + " (?, ?, ?,?);";

    private static final String SELECT_USER_BY_ID = "select id,dname,price, category,photo from menu where id =?";
    private static final String SELECT_ALL_USERS = "select * from menu";
    private static final String DELETE_USERS_SQL = "delete from menu where id = ?;";
    private static final String UPDATE_USERS_SQL = "update menu set dname = ?,price= ?, category =?,photo=? where id = ?;";

    public MenuDAO(){

    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertMenu(Menu menu) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, menu.getDname());
            preparedStatement.setString(2, menu.getPrice());
            preparedStatement.setString(3, menu.getCategory());
            preparedStatement.setString(4, menu.getPhoto());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Menu selectMenu(int id) {
        Menu menu = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String dname = rs.getString("dname");
                String price = rs.getString("price");
                String category = rs.getString("category");
                String photo = rs.getString("photo");
                menu = new Menu(id, dname, price, category,photo);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return menu;
    }

    public List<Menu> selectAllMenu() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Menu> menus = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String dname = rs.getString("dname");
                String price = rs.getString("price");
                String category = rs.getString("category");
                String photo = rs.getString("photo");

                menus.add(new Menu(id, dname, price, category,photo));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return menus;
    }

    public boolean deleteMenu(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    public boolean updateMenu(Menu menu) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            System.out.println("updated Menu:"+statement);
            statement.setString(1, menu.dname);
            statement.setString(2, menu.getPrice());
            statement.setString(3, menu.getCategory());
            statement.setString(4, menu.getPhoto());
            statement.setInt(5, menu.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
