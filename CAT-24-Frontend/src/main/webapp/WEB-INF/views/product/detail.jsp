<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Cat 24 - Product</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.servletContext.contextPath }/assets/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${pageContext.servletContext.contextPath }/assets/css/modern-business.css" rel="stylesheet">
  <link href="${pageContext.servletContext.contextPath }/assets/css/main.css" rel="stylesheet">
</head>

<body>

  <!-- Navigation -->
    <c:import url="/WEB-INF/views/includes/main_nav.jsp"/>
 
   <!-- Page Content -->
  <div class="container">
      
    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">
    </h1>
    <div style="margin-top:100px;">
    </div>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="${pageContext.servletContext.contextPath }/">Home</a>
      </li>
      <li class="breadcrumb-item active">상품</li>
    </ol>

    <div class="row">
    
      <div class="col-lg-3">
        <h1 class="my-4">Cat 24</h1>
        <div class="list-group">
       	  <c:forEach items = "${categorylist}" var="vo" varStatus="status">
             <a href="${pageContext.servletContext.contextPath }/product/list/category/${vo.category_no}" class="list-group-item">${vo.category_name}</a>
          </c:forEach>	
        </div>
      </div>
      <div class="col-lg-9">
       <div class="row">
       <c:forEach items = "${get}" var="vo" varStatus="status">
            <div class="col-md-6">
        <img class="img-fluid" src="${pageContext.servletContext.contextPath }${vo.product_image}" alt="">
      </div>

      <div class="col-md-6">
       	<h3>${vo.product_name}</h3>
        <table class="table">
        	<tbody>
        		<tr>
        			<td>판매가</td>
        			<td>${vo.selling_price}</td>
        		</tr>
        		 <tr>
        			<td>상품명</td>
        			<td>${vo.product_name}</td>
        		</tr>
        		 <tr>
        			<td>상품코드</td>
        			<td>${vo.product_code}</td>
        		</tr>
        		 <tr>
        			<td>요약설명</td>
        			<td>${vo.summary}</td>
        		</tr>         		        		
        		<tr>
        			<td>주문수량</td>
        			<td><input type="number" id="product_sum" name="product_sum" value="1" min="1" max="100"></td>
        		</tr>
        	</tbody>
        </table>
        <h4>총상품 금액 : </h4>
        <a href="#" class="btn btn-danger">바로 구매</a>
        <a href="#" class="btn btn-danger">장바구니</a>
      </div>
        	</c:forEach>
      </div>
      
	  <!-- Related Projects Row -->
    <h3 class="my-4">Related Projects</h3>

    <div class="row">

    <!--   <div class="col-md-3 col-sm-6 mb-4">
        <a href="#">
          <img class="img-fluid" src="http://placehold.it/500x300" alt="">
        </a>
      </div>

      <div class="col-md-3 col-sm-6 mb-4">
        <a href="#">
          <img class="img-fluid" src="http://placehold.it/500x300" alt="">
        </a>
      </div>

      <div class="col-md-3 col-sm-6 mb-4">
        <a href="#">
          <img class="img-fluid" src="http://placehold.it/500x300" alt="">
        </a>
      </div>

      <div class="col-md-3 col-sm-6 mb-4">
        <a href="#">
          <img class="img-fluid" src="http://placehold.it/500x300" alt="">
        </a>
      </div> -->

    </div>
    <!-- /.row -->
    </div>
        
    
    <!-- /.row -->
	</div>

  </div>
  
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="${pageContext.servletContext.contextPath }/assets/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.servletContext.contextPath }/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>