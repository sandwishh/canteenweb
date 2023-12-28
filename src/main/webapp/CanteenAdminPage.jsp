
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
  <title>Canteen Admin</title>
  <%@include file="allCss.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<h1 align="center">Welcome System Admin</h1>

<div class="container">
  <div class="row p-5">
    <div class="col-md-3">
      <a href="addmenupage.jsp" enctype="multipart/form-data">
        <div class="card">
          <div class="card-body text-center">
            <i class="fa-solid fa-user fa-3x"></i><br>
            <h4>Fix Password</h4>
          </div>
        </div>
      </a>
    </div>

    <div class="col-md-3">
      <a href="menu-form.jsp" enctype="multipart/form-data">
        <div class="card">
          <div class="card-body text-center">
            <i class="fa-solid fa-plus fa-3x"></i><br>
            <h4>Add Menu</h4>
          </div>
        </div>
      </a>
    </div>

    <div class="col-md-3">
      <a href="menu-list.jsp">
        <div class="card">
          <div class="card-body text-center">
            <i class="fa-solid fa-address-book fa-3x"></i><br>
            <h4>Display Menu</h4>
          </div>
        </div>
      </a>
    </div>

    <div class="col-md-3">
      <a href="loginAndRegister.jsp">
      <div class="card">
        <div class="card-body text-center">
          <i class="fa-solid fa-right-from-bracket fa-3x"></i><br>
          <h4>Logout</h4>
        </div>
      </div>
      </a>
    </div>
  </div>
</div>
</body>
</html>
