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
      <c:forEach items = "${productlist}" var="vo" varStatus="status">
      	<div class="col-lg-6 portfolio-item">
        	<div class="card h-100">
          		<a href="${pageContext.servletContext.contextPath }/product/list/${vo.product_no}"><img class="card-img-top" src="${pageContext.servletContext.contextPath }${vo.product_image}" alt=""></a>
          		<div class="card-body">
            	<h4 class="card-title">
              		<a href="${pageContext.servletContext.contextPath }/product/list/${vo.product_no}">${vo.product_name}</a>
            	</h4>
            	<p class="card-text">${fn:split(vo.selling_price,'.')[0]}원</p>
            	<p class="card-text">${vo.summary}</p>
          </div>
        </div>
      </div>
      </c:forEach>
      </div>
     <div style="margin-top:30px;">
     </div>
        <!-- Pagination -->
    <ul class="pagination" style="padding-left:330px;">
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
          <span class="sr-only">Previous</span>
        </a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#">1</a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#">2</a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#">3</a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
          <span class="sr-only">Next</span>
        </a>
      </li>
    </ul>  
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