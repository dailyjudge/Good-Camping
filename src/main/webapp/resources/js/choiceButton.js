//const st = {};
//
//st.flap = document.querySelector('#flap');
//st.toggle = document.querySelector('.camping-choice-toggle');
//
//st.choice1 = document.querySelector('#choice1');
//st.choice2 = document.querySelector('#choice2');
//
//st.flap.addEventListener('transitionend', () => {
//	
//	console.log("클릭");
//	
//    if (st.choice1.checked) {
//        st.toggle.style.transform = 'rotateY(-15deg)';
//        setTimeout(() => st.toggle.style.transform = '', 400);
//    } else {
//        st.toggle.style.transform = 'rotateY(15deg)';
//        setTimeout(() => st.toggle.style.transform = '', 400);
//    }
//
//})
//
//st.clickHandler = (e) => {
//	
//	console.log(e);
//	
//    if (e.target.tagName === 'LABEL') {
//        setTimeout(() => {
//            st.flap.children[0].textContent = e.target.textContent;
//        }, 250);
//        
//    }
//    
//    let optionVal = $('#flap').children('#option-value').val();
//    console.log(optionVal);
//    console.log('dddd');
//    if(optionVal == 'theme') {
//    	// 지도로 검색 띄워주기
//    	
//    	$('#flap').children('#option-value').val('map');
//    } else {
//    	
//    	$('#flap').children('#option-value').val('theme');
//    }
//}
//
//document.addEventListener('DOMContentLoaded', () => {
//    st.flap.children[0].textContent = st.choice2.nextElementSibling.textContent;
//});
//
//document.addEventListener('click', (e) => st.clickHandler(e));

$(function() {
	$('.camping-choice-toggle label').click(function() {
		
		let optionVal = $('#flap').children('#option-value').val();
	    console.log(optionVal);
	    console.log('dddd');
	    if(optionVal == 'theme') {
	    	// 지도로 검색 띄워주기
	    	$('#flap').children('#option-value').val('map');
	    	
	    	$('.camping-search-theme-main-container').css('display', 'none');
	    	$('.camping-search-map-main-container').css('display', 'block');
	    } else {
	    	
	    	$('#flap').children('#option-value').val('theme');	
	    	
	    	$('.camping-search-theme-main-container').css('display', 'block');
	    	$('.camping-search-map-main-container').css('display', 'none');
	    	
	    }
	});
});