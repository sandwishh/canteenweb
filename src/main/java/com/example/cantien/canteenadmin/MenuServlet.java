package com.example.cantien.canteenadmin;

//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;

import java.io.IOException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.example.cantien.canteenadmin.MenuDAO;
import com.example.cantien.canteenadmin.Menu;

import java.io.IOException;

@WebServlet("/")
@MultipartConfig
public class MenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MenuDAO menuDAO;

    public void init() {
        menuDAO = new MenuDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertMenu(request, response);
                    break;
                case "/delete":
                    deleteMenu(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateMenu(request, response);
                    break;
                default:
                    listMenu(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listMenu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Menu> listMenu = menuDAO.selectAllMenu();
        request.setAttribute("listMenu", listMenu);
        RequestDispatcher dispatcher = request.getRequestDispatcher("menu-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("menu-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Menu existingMenu = menuDAO.selectMenu(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("menu-form.jsp");
        request.setAttribute("menu", existingMenu);
        dispatcher.forward(request, response);

    }

    private void insertMenu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String dname = request.getParameter("dname");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        Part part=request.getPart("photo");
        String fileName=part.getSubmittedFileName();


        Menu newMenu = new Menu(dname, price, category,fileName);
        menuDAO.insertMenu(newMenu);
        response.sendRedirect("list");
    }

    private void updateMenu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String dname = request.getParameter("dname");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        Part part=request.getPart("photo");
        String fileName=part.getSubmittedFileName();


        Menu book = new Menu(id, dname, price, category,fileName);
        menuDAO.updateMenu(book);
        response.sendRedirect("list");
    }

    private void deleteMenu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        menuDAO.deleteMenu(id);
        response.sendRedirect("list");

    }

}