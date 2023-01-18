<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <nav id="top-menu-nav">
      <div id="top-menu-log">
        <a href="http://localhost:8080/camping/"> <img id="logo-img" src="resources/home_img/logo.png"/></a>
      </div>
      <ul id="top-menu-something">
        <li class="something-icon">
          <a href="go.camping.like"><img src="resources/home_img/heart.png" /></a>
        </li>
        <li class="something-icon">
          <a href="go.stuff.cart"><img src="resources/home_img/basket.png" /></a>
        </li>
        <li class="something-icon">
          <a href="myPage.go" ><img src="resources/home_img/login.png" /></a>
        </li>
        <li class="something-icon">
          <button onclick="location.href='logout.do'">로그아웃(임시)</button>
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
        <li class="second-menu-li" onclick="location.href='go.theme.find'">테마로 검색</li>
        <li class="second-menu-li" onclick="location.href='go.camping.shop'">캠핑 상점</li>
        <li class="second-menu-li">메뉴4</li>
      </ul>
    </nav>