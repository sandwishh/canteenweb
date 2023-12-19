package com.example.cantien.canteenadmin;

//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet(name = "MenuAdd", value = "/MenuAdd")
@MultipartConfig
public class MenuAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String menuname=request.getParameter("dname");
            String price=request.getParameter("price");
            String category=request.getParameter("category");
            Part part=request.getPart("photo");
            String fileName=part.getSubmittedFileName();

            MenuDtls md=new MenuDtls();

            md.setDishName(menuname);
            md.setPrice(price);
            md.setCategory(category);
            md.setPhotoName(fileName);
            md.setPhotoName(part.getSubmittedFileName());
            out.println(fileName);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}