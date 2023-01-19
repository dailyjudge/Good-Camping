<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="slide">
      <div class="slideList">
        <div class="slideImg fade">
          <img
            class="slideshow-image"
            src="https://p4.wallpaperbetter.com/wallpaper/732/641/312/nature-sunset-landscape-camping-wallpaper-preview.jpg"
          />
        </div>
        <div class="slideImg">
          <img
            class="slideshow-image"
            src="https://p4.wallpaperbetter.com/wallpaper/44/633/273/campfire-landscape-vibes-camping-wallpaper-preview.jpg"
          />
        </div>

        <div class="slideImg">
          <img
            class="slideshow-image"
            src="https://p4.wallpaperbetter.com/wallpaper/616/958/383/stars-trees-camping-camp-fire-camp-night-hd-wallpaper-preview.jpg"
          />
        </div>
        <div class="slideImg">
          <img class="slideshow-image" src="resources/home_img/wallpaperbetter.jpg" />
        </div>
      </div>
      <form action="do.search.campingSite" class="search-input-form" onsubmit="return searchCampingSite()">
        <div id="allform">
          <div id="input-button">
            <input id="search-input" placeholder="검색어 입력" name="searchValue"/>
            <button class="btn">검색</button>
          </div>
          <div id="city">
            <select name="sido1" id="sido1"></select>
            <select name="gugun1" id="gugun1"></select>
          </div>
        </div>
      </form>
    </div>
    