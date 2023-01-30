<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <nav id="top-menu-nav">
      <div id="top-menu-log">
        <a href="http://localhost:8080/camping/"> <img id="logo-img" src="resources/home_img/logo.png"/></a>
      </div>
      <div class="top-menu-login">
			<button onclick="location.href='go.Login.Head'">로그인</button>
      </div>
      <ul id="top-menu-something2-ul">
        <li id="something-icon2">
          <a href=""><img src="resources/home_img/menu_bar.png" /></a>
        </li>
      </ul>
    </nav>
    <nav id="second-menu-nav">
      <c:choose>
    	<c:when test="${color == 1 }">
    		<ul id="second-menu-ul" style="background-color: #45526C">
	    	    <li class="second-menu-li" style="background-color: #45526C" onclick="location.href='go.camping.find'">캠핑장 찾기</li>
		        <li class="second-menu-li" style="background-color: #45526C" onclick="location.href='go.theme.find'">옵션 검색</li>
		        <li class="second-menu-li" style="background-color: #45526C" onclick="location.href='go.camping.shop'">캠핑 스토어</li>
	       	 	<li class="second-menu-li" style="background-color: #45526C" onclick="location.href='go.Bulletin.Main'">게시판</li>
      		</ul>
    	</c:when>
    	<c:otherwise>
    		<ul id="second-menu-ul">
	    	    <li class="second-menu-li" onclick="location.href='go.camping.find'">캠핑장 찾기</li>
		        <li class="second-menu-li" onclick="location.href='go.theme.find'">옵션 검색</li>
		        <li class="second-menu-li" onclick="location.href='go.camping.shop'">캠핑 스토어</li>
	       	 	<li class="second-menu-li" onclick="location.href='go.Bulletin.Main'">게시판</li>
      		</ul>
    	</c:otherwise>
    </c:choose>
    </nav>
    
    
