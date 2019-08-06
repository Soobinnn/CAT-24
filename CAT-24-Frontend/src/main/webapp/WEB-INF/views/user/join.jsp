<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Cat 24 - Join</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.servletContext.contextPath }/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template-->
  <link href="${pageContext.servletContext.contextPath }/assets/css/sb-admin.css" rel="stylesheet">
  <link href="${pageContext.servletContext.contextPath }/assets/css/main.css" rel="stylesheet">
</head>

<body class="bg-dark">
  
   <!-- Navigation -->
  <c:import url="/WEB-INF/views/includes/main_nav.jsp"/>
  
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        <form>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-10">
                <div class="form-label-group">
                  <input type="text" id="id" class="form-control" placeholder="ID" required="required" autofocus="autofocus">
                  <label for="id">ID</label>
                </div>
              </div>
              <div class="col-md-2">
                <div class="form-label-group">
                </div>
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-10">
                <div class="form-label-group">
                   <input type="password" id="password" class="form-control" placeholder="PASSWORD" required="required">
             	   <label for="password">PASSWORD</label>
                </div>
              </div>
              <div class="col-md-2">
                <div class="form-label-group">
                </div>
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-10">
                <div class="form-label-group">
                   <input type="text" id="name" class="form-control" placeholder="NAME" required="required">
             	   <label for="name">NAME</label>
                </div>
              </div>
              <div class="col-md-2">
                <div class="form-label-group">
                </div>
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              <input type="radio" id="gender" class="form-control" placeholder="gender" required="required">
              <label for="inputEmail">Email address</label>
            </div>
          </div>      
          <div class="form-group">
            <div class="form-label-group">
              <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="required">
              <label for="inputEmail">Email address</label>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="required">
                  <label for="inputPassword">Password</label>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm password" required="required">
                  <label for="confirmPassword">Confirm password</label>
                </div>
              </div>
            </div>
          </div>
          <a class="btn btn-primary btn-block" href="login.html">Register</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="login.html">Login Page</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.servletContext.contextPath }/assets/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.servletContext.contextPath }/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${pageContext.servletContext.contextPath }/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>
