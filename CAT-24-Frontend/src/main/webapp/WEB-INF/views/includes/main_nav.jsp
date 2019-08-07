<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-coral fixed-top">
    <div class="container">
      <a id="nav-title" class="navbar-brand" href="${pageContext.servletContext.contextPath }/">Cat 24</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.servletContext.contextPath}/product/list">상품</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.servletContext.contextPath}/cart/">장바구니</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.servletContext.contextPath}/user/login">로그인</a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="${pageContext.servletContext.contextPath}/user/join">회원가입</a>
          </li>	
        </ul>
      </div>
    </div>
  </nav>