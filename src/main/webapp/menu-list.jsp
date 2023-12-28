<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.example.cantien.canteenadmin.MenuDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.cantien.canteenadmin.Menu" %>
<html>
<head>
    <title>User Management Application</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <!--<link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">!-->
    <%@include file="allCss.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<header>


</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Menu</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                New Menu</a>
        </div>
        <br>
        <table class="table table-striped">
            <thead class="bg-custom text-white">
            <tr>
                <th>ID</th>
                <th>Photo</th>
                <th>Dish Name</th>
                <th>Price</th>
                <th>Category</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="menu" items="${listMenu}">

                <tr>
                    <td><c:out value="${menu.id}" /></td>
                    <td><c:out value="${menu.photo}" /></td>
                    <td><c:out value="${menu.dname}" /></td>
                    <td><c:out value="${menu.price}" /></td>
                    <td><c:out value="${menu.category}" /></td>
                    <td><a href="edit?id=<c:out value='${menu.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="delete?id=<c:out value='${menu.id}' />">Delete</a></td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</div>

</body>
</html>