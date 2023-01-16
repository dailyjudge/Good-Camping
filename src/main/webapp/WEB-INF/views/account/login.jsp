<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <nav id="top-menu-nav">
      <div id="top-menu-log">
        <a href="http://localhost:8080/camping/"> <img id="logo-img" src="resources/home_img/logo.png"/></a>
      </div>
      <div class="top-menu-login">
			<button onclick="location.href='go.Login.Head'">로그인<small>/회원가입</small></button>
      </div>
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
    
    
