<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <nav id="top-menu-nav">
      <div id="top-menu-log">
        <a href="http://localhost:8080/camping/"> <img id="logo-img" src="resources/home_img/logo.png"/></a>
      </div>
      <ul id="top-menu-something">
        <li class="something-icon">
          <c:choose>
          	<c:when test="${Click == 1 }">
 	         <a href="go.camping.like"><img src="resources/home_img/myPage_heart_click.png" /></a>
          	</c:when>
			<c:otherwise>
	          <a href="go.camping.like"><img src="resources/home_img/heart.png" /></a>
			</c:otherwise>          
          </c:choose>
        </li>
        <li class="something-icon">
        	<c:choose>
          	<c:when test="${Click == 2 }">
 	         <a href="go.stuff.cart"><img src="resources/home_img/myPage_basket_click.png" /></a>
          	</c:when>
			<c:otherwise>
	          <a href="go.stuff.cart"><img src="resources/home_img/basket.png" /></a>
			</c:otherwise>          
          </c:choose>
          
        </li>
        <li class="something-icon">
          <a><img src="resources/home_img/login.png" /></a>
        </li>
      </ul>
      <ul id="top-menu-something2-ul">
        <li id="something-icon2">
          <a href=""><img src="resources/home_img/menu_bar.png" /></a>
        </li>
      </ul>
    </nav>
    <nav id="second-menu-nav">
      <ul id="second-menu-ul">
       <li class="second-menu-li" onclick="location.href='go.camping.find'">캠핑장 찾기</li>
        <li class="second-menu-li" onclick="location.href='go.theme.find'">옵션 검색</li>
        <li class="second-menu-li" onclick="location.href='go.camping.shop'">캠핑 상점</li>
        <li class="second-menu-li">메뉴4</li>
      </ul>
    </nav>