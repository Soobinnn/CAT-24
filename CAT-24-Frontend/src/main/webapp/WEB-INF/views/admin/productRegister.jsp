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

  <title>Cat 24 - Admin</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.servletContext.contextPath }/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="${pageContext.servletContext.contextPath }/assets/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.servletContext.contextPath }/assets/css/sb-admin.css" rel="stylesheet">

	<script>
		 function productRegister()
		 {
				 var form = document.getElementById("form2");
				form.submit();
		 }
	</script>
</head>

<body id="page-top">

   <!-- Navigation -->
  <c:import url="/WEB-INF/views/includes/admin_nav.jsp"/>

  <div id="wrapper">

    <!-- Sidebar -->
   <c:import url="/WEB-INF/views/includes/admin_sidebar.jsp"/>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="#">상품 관리</a>
          </li>
          <li class="breadcrumb-item active">상품 등록</li>
        </ol>

        <form id="form2" action="${pageContext.servletContext.contextPath}/admin/productregister" method="post"  enctype="multipart/form-data">
        <div class="card card-register mx-auto mt-5 ">
    			<div class="card-header bg-dark text-white ">기본정보</div>
     	 			<div class="card-body">
     	    			 <div class="form-group">
      	     				 <div class="form-row">
       	       					<div class="col-md-2">
       	         					<div class="form-label-group">상품명</div>
      	        				</div>
       	       					<div class="col-md-10">
       	         					<div class="form-label-group">
       	          						<input type="text" id="product_name" name="product_name" class="form-control" required="required" autofocus="autofocus">
       	           						<label for="product_name">상품명</label>
       	         					</div>
       	       					</div>
       	     				</div>
       	   				</div>
 
           	   			<div class="form-group">
       	     				<div class="form-row">
       	       					<div class="col-md-2">
        	        				<div class="form-label-group">모델명</div>
              					</div>
              					<div class="col-md-10">
                					<div class="form-label-group">
                  		 				<input type="text" id="model_name" name="model_name" class="form-control"  required="required">
             	   						<label for="model_name">모델명</label>
                					</div>
              					</div>
            				</div>
         				</div>

           	   			<div class="form-group">
       	     				<div class="form-row">
       	       					<div class="col-md-2">
        	        				<div class="form-label-group">상품코드</div>
              					</div>
              					<div class="col-md-10">
                					<div class="form-label-group">
                  		 				<input type="text" id="product_code" name="product_code" class="form-control"  required="required">
             	   						<label for="product_code">상품코드</label>
                					</div>
              					</div>
            				</div>
         				</div>

           	   			<div class="form-group">
       	     				<div class="form-row">
       	       					<div class="col-md-2">
        	        				<div class="form-label-group">자체상품코드</div>
              					</div>
              					<div class="col-md-10">
                					<div class="form-label-group">
                  		 				<input type=text id="custom_product_code" name="custom_product_code" class="form-control" required="required">
             	   						<label for="custom_product_code">자체상품코드</label>
                					</div>
              					</div>
            				</div>
         				</div>
       	   				
       	   				<div class="form-group">
       	     				<div class="form-row">
       	       					<div class="col-md-2">
        	       					<div class="form-label-group">요약설명</div>
              					</div>
              					<div class="col-md-10">
                					<div class="form-label-group">
                   						<input type="text" id="summary" name="summary" class="form-control" required="required">
             	   						<label for="summary">요약설명</label>
                					</div>
              					</div>
            				</div>
         				</div>
         				
          	   			<div class="form-group">
       	     				<div class="form-row">
       	       					<div class="col-md-2">
        	        				<div class="form-label-group">설명</div>
              					</div>
              					<div class="col-md-10">
                					<div class="form-label-group">
                  		 				<input type="text" id="detail" name="detail" class="form-control"  required="required">
             	   						<label for="detail">설명</label>
                					</div>
              					</div>
            				</div>
         				</div>
          			</div> 
          	</div>
          
           <div class="card card-register mx-auto mt-5 ">
    	  		<div class="card-header bg-dark text-white ">판매정보</div>
     	 			<div class="card-body">
     	     			
						<div class="form-group">
      	      				<div class="form-row">
       	       					<div class="col-md-2">
       	         					<div class="form-label-group">원가</div>
      	        				</div>
       	       					<div class="col-md-10">
       	         					<div class="form-label-group">
       	           						<input type="text" id="cost_price" name="cost_price" class="form-control" required="required" autofocus="autofocus">
       	           						<label for="cost_price">원가</label>
       	         					</div>
       	       					</div>
       	     				</div>
       	   				</div>
     	     			
     	     			<div class="form-group">
      	      				<div class="form-row">
       	       					<div class="col-md-2">
       	         					<div class="form-label-group">판매가</div>
      	        				</div>
       	       					<div class="col-md-10">
       	         					<div class="form-label-group">
       	           						<input type="text" id="selling_price" name="selling_price" class="form-control"  required="required" autofocus="autofocus">
       	           						<label for="selling_price">판매가</label>
       	         					</div>
       	       					</div>
       	     				</div>
       	   				</div>
       	   				
          			</div> 
          	</div>
          
          <div class="card card-register mx-auto mt-5 ">
    	  <div class="card-header bg-dark text-white ">표시 설정</div>
     	 <div class="card-body">
     	     <div class="form-group">
      	      <div class="form-row">
       	       <div class="col-md-2">
       	         <div class="form-label-group">
       	         	표시 상태
       	         </div>
      	        </div>
       	       <div class="col-md-10">
       	         <div class="form-label-group">
       	           <input type="text" id="sell_yn" name="sell_yn" class="form-control"  required="required" autofocus="autofocus">
       	           <label for="sell_yn">표시 상태</label>
       	         </div>
       	       </div>
       	     </div>
       	   </div>
       	   
       	   <div class="form-group">
      	      <div class="form-row">
       	       <div class="col-md-2">
       	         <div class="form-label-group">
       	         	할인 여부
       	         </div>
      	        </div>
       	       <div class="col-md-10">
       	         <div class="form-label-group">
       	           <input type="text" id="discount_yn" name="discount_yn" class="form-control" required="required" autofocus="autofocus">
       	           <label for="discount_yn">할인 여부</label>
       	         </div>
       	       </div>
       	     </div>
       	   </div>
       	   
       	   	   <div class="form-group">
      	      <div class="form-row">
       	       <div class="col-md-2">
       	         <div class="form-label-group">
       	         	상품 분류
       	         </div>
      	        </div>
			    <div class="col-md-10">
       	         <div class="form-label-group">          
                  	<select id="category_no" name=category_no class="form-control">
                  		<c:forEach items = "${categorylist}" var="vo" varStatus="status">
                  		   <a href="${pageContext.servletContext.contextPath }/product/list/category/${vo.category_no}" class="list-group-item">${vo.category_name}</a>
            			   <option value="${vo.category_no}">${vo.category_name}</option>
            			</c:forEach>
                  	</select>
       	         </div>
       	       </div>
       	     </div>
       	   </div>
          </div> 
          </div>
          
            <div class="card card-register mx-auto mt-5 ">
    	  <div class="card-header bg-dark text-white ">이미지 정보</div>
     	 <div class="card-body">
     	     <div class="form-group">
      	      <div class="form-row">
       	       <div class="col-md-2">
       	         <div class="form-label-group">
       	         	상품 이미지
       	         </div>
      	        </div>
       	       <div class="col-md-10">
       	         <div class="form-label-group">
       	           		<input type="file" name="productimg">
       	           		<label for="product-file">상품 이미지</label>
       	         </div>
       	       </div>
       	     </div>
       	   </div>
       	   	   <div class="form-group">
      	      <div class="form-row">
       	       <div class="col-md-2">
       	         <div class="form-label-group">
       	         	추가 이미지
       	         </div>
      	        </div>
       	       <div class="col-md-10">
       	         <div class="form-label-group">
       	           <input type="text" id="product_subimage" name="product_subimage" class="form-control"  required="required" autofocus="autofocus">
       	           <label for="product_subimage"></label>
       	         </div>
       	       </div>
       	     </div>
       	   </div>
          </div> 
          <a class="btn btn-primary btn-block" href="#" onClick="productRegister()">Register</a>
          </div>
         
   
        </form>

        <p class="small text-center text-muted my-5">
          <em>More table examples coming soon...</em>
        </p>

      </div>
      <!-- /.container-fluid -->

      <!-- Sticky Footer -->
      <footer class="sticky-footer">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright © Your Website 2019</span>
          </div>
        </div>
      </footer>

    </div>
    <!-- /.content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.servletContext.contextPath }/assets/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.servletContext.contextPath }/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${pageContext.servletContext.contextPath }/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->
  <script src="${pageContext.servletContext.contextPath }/assets/vendor/datatables/jquery.dataTables.js"></script>
  <script src="${pageContext.servletContext.contextPath }/assets/vendor/datatables/dataTables.bootstrap4.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${pageContext.servletContext.contextPath }/assets/js/sb-admin.min.js"></script>

  <!-- Demo scripts for this page-->
  <script src="${pageContext.servletContext.contextPath }/assets/js/demo/datatables-demo.js"></script>

</body>

</html>
