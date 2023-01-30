<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <link rel="stylesheet" href="resources/css/board-start.css">
    <script src="https://kit.fontawesome.com/ece9d84a35.js" crossorigin="anonymous"></script>
</head>
<body>
<img class="forest-back" src="resources/board-img/forest.png">
<img class="wellcome-img" src="resources/board-img/wellcome.png">
  <div id="board-top-wrap">
    <nav id="start-left-board">
        <ul>
          <li onclick="location.href='go.Bulletin.Main'">
            <div class="home-icon col-dif">
                <img class="nav-img" src="resources/board-img/weather.png" >
            </div>
          </li>
          <li>
            <div class="about-icon">
                <img class="nav-img" src="resources/board-img/mail.png">
              </div>
          </li>
          <li>
            <div class="work-icon col-dif">
                <img class="nav-img" src="resources/board-img/money.png">
            </div>
          </li>
          <li onclick="location.href='go.board.comu'">
            <div class="mail-icon">
                <img class="nav-img" src="resources/board-img/comu.png">
            </div>
          </li>
        </ul>
      </nav>
      
<!--       <div class="wellcome">
      	wellcome
      </div> -->
   </div>
</body>
</html>