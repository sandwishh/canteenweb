package com.example.cantien.register;

//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
// jakarta.servlet.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String department=request.getParameter("department");

        Member member=new Member(uname,email,password,department);

        RegisterDao rDao=new RegisterDao();
        String result=rDao.insert(member);
        //response.getWriter().print(result);
        response.sendRedirect("regisuccess.jsp");
    }
}