$(function() {
   
   const st = {};

   st.flap = document.querySelector('#camping-choice-flap');
   st.toggle = document.querySelector('.camping-choice-toggle');

   st.choice1 = document.querySelector('#choice1');
   st.choice2 = document.querySelector('#choice2');



   st.flap.addEventListener('transitionend', () => {

	   if (st.choice1.checked) {
		   st.toggle.style.transform = 'rotateY(-15deg)';
		   $('#flap').children('#option-value').val('map');
    	
		   $('.camping-search-theme-main-container').css('display', 'none');
		   $('.camping-search-map-main-container').css('display', 'block');
		   setTimeout(() => st.toggle.style.transform = '', 400);
	   } else {
		   st.toggle.style.transform = 'rotateY(15deg)';
        
		   $('.camping-search-theme-main-container').css('display', 'block');
		   $('.camping-search-map-main-container').css('display', 'none');
        
		   setTimeout(() => st.toggle.style.transform = '', 400);
	   }

   });

   st.clickHandler = (e) => {

	   if (e.target.tagName === 'LABEL') {
		   setTimeout(() => {
		   }, 250);
	   }
   }

   document.addEventListener('DOMContentLoaded', () => {
	   st.flap.children[0].textContent = st.choice2.nextElementSibling.textContent;
   });

   document.addEventListener('click', (e) => st.clickHandler(e));

});
