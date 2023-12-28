<%--
  Created by IntelliJ IDEA.
  User: tkrit
  Date: 12/26/2023
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <title>Canteen Admin</title>
    <%@include file="allCss.jsp"%>
    <title>AddMenu</title>
</head>
<body>
<%@include file="navbar.jsp"%>
<ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Menu</a> </li>
</ul>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${menu != null}">
                <form action="update" method="post">
            </c:if>
            <c:if test="${menu == null}">
                <form action="insert" method="post">
            </c:if>
            <caption>
                    <h2>
                        <c:if test="${menu !=null}">
                        Edit Menu
                            </c:if>
                        <c:if test="${menu == null}">
                            Add New Menu
                            </c:if>
                    </h2>
            </caption>

            <c:if test="${menu != null}">
                <input type="hidden" name="id" value="<c:out value='${menu.id}'/>">
                </c:if>

                    <fieldset class="for-group">
                        <label>photo Name</label><input type="text" value="<c:out value='${menu.photo}'/>" class="form-control" name="photo" required="required">
                    </fieldset>

                <fieldset class="for-group">
                    <label>Dish Name</label><input type="text" value="<c:out value='${menu.name}'/>" class="form-control" name="name" required="required">
                </fieldset>

                <fieldset class="for-group">
                    <label>Price</label><input type="text" value="<c:out value='${menu.price}'/>" class="form-control" name="price" required="required">
                </fieldset>

                <fieldset class="for-group">
                    <label>Category</label><input type="text" value="<c:out value='${menu.category}'/>" class="form-control" name="Category" required="required">
                </fieldset>

                <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>

</body>
</html>
