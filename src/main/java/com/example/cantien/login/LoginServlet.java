package com.example.cantien.login;

//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String uname=request.getParameter("uname");
        String password=request.getParameter("password");
        String department=request.getParameter("department");

        LoginBean loginBean=new LoginBean();
        loginBean.setUname(uname);
        loginBean.setPassword(password);
        loginBean.setDepartment(department);

        LoginDao loginDao = new LoginDao();

        if(department.equals("System Admin") && loginDao.validate(loginBean)){
            response.sendRedirect("SystemAdminPage.jsp");
        }
        else if (department.equals("Canteen Admin") && loginDao.validate(loginBean)) {
            response.sendRedirect("CanteenAdminPage.jsp");
        }
        else if (department.equals("User") && loginDao.validate(loginBean)) {
            //response.sendRedirect("loginsuccess.jsp");
            HttpSession session = request.getSession(true);
            session.putValue("uname",password);

            response.sendRedirect(request.getContextPath()+"/second");
        }


        /*if (loginDao.validate(loginBean)) {
            response.sendRedirect("loginsuccess.jsp");
        }*/
        else {
            //response.sendRedirect("loginAndRegister.jsp");
            response.sendRedirect("no.jsp");


        }
    }
}