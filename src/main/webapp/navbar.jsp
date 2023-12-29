<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <h3>Gg Canteen</h3>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="CanteenAdminPage.jsp"><i class="fas fa-home"></i>Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Menu</a></li>
        </ul>

        <ul class="navbar-nav">
            <li><a href="loginAndRegister.jsp"
                   class="nav-link">logout</a></li>
        </ul>

    </div>
</nav>