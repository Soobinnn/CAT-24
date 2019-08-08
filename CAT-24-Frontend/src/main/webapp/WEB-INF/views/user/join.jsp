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
<script>
 function joinRegister()
 {
	 var form = document.getElementById("form1");
	form.submit();
 }
</script>
</head>

<body class="bg-dark">
  
   <!-- Navigation -->
  <c:import url="/WEB-INF/views/includes/main_nav.jsp"/>
  
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        <form id="form1" action="${pageContext.servletContext.contextPath }/user/join" method="post">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-10">
                <div class="form-label-group">
                  <input type="text" id="id" name="id" class="form-control" placeholder="ID" required="required" autofocus="autofocus">
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
                   <input type="password" id="password" name="password" class="form-control" placeholder="PASSWORD" required="required">
             	   <label for="password">비밀번호</label>
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
                   <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="PASSWORD" required="required">
             	   <label for="confirmPassword">비밀번호 확인</label>
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
                   <input type="text" id="name" name="name" class="form-control" placeholder="NAME" required="required">
             	   <label for="name">이름</label>
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
          	<div class="col-md-2">
           	 <div class="form-label-group">
              	<input type="radio" id="gender-man" name="gender" class="form-control" value="M" checked>
             	 <label for="gender-man">남성</label>
            </div>
            </div>
            <div class="col-md-2">
           	 <div class="form-label-group">
           		<input type="radio" id="gender-girl" name="gender" class="form-control" value="W">
             	 <label for="gender-girl">여성</label>
             	 </div>
             	 </div>
           </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-10">
                <div class="form-label-group">
                   <input type="text" id="zipcode" name="zipcode" class="form-control" placeholder="" required="required">
             	   <label for="name">우편번호</label>
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
              <div class="col-md-5">
                <div class="form-label-group">
                   <input type="text" id="address" name="address" class="form-control" placeholder="" required="required">
             	   <label for="address">주소</label>
                </div>
              </div>
              <div class="col-md-5">
                <div class="form-label-group">
                   <input type="text" id="address_detail" name="address_detail" class="form-control" placeholder="" required="required">
             	   <label for="address_detail">상세주소</label>
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
               <div class="col-md-5">
                <div class="form-label-group">
                   <input type="text" id="home_number" name="home_number" class="form-control" placeholder="" required="required">
             	   <label for="home_number">집전화</label>
                </div>
              </div>
              <div class="col-md-5">
                <div class="form-label-group">
                   <input type="text" id="phone" name="phone" class="form-control" placeholder="" required="required">
             	   <label for="phone">핸드폰번호</label>
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
                   <input type="text" id=email name="email" class="form-control" placeholder="" required="required">
             	   <label for="email">이메일</label>
                </div>
              </div>
              <div class="col-md-2">
                <div class="form-label-group">
                </div>
              </div>
            </div>
          </div> 
          <a class="btn btn-primary btn-block" href="#" onClick="joinRegister()">Register</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="${pageContext.servletContext.contextPath }/user/login">로그인 화면</a>
          <a class="d-block small mt-3" href="${pageContext.servletContext.contextPath }/">취소</a>
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
