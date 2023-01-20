function searchToggle(obj, evt){
    var container = $(obj).closest('.search-wrapper');
        if(!container.hasClass('active')){
            container.addClass('active');
            evt.preventDefault();
            setTimeout(() => container.find('.search-input').focus(), 1000);
        }
        else if(container.hasClass('active') && $(obj).closest('.input-holder').length == 0){
            container.removeClass('active');
            // clear input
            container.find('.search-input').val('');
            $('.search-warn').css('display', 'none');
        }
}

function enterkey() {
	  if (window.event.keyCode == 13) {
			let searchValue = $('.search-input').val();

			if(searchValue == '') {
				$('.search-warn').css('display', 'block');
				$('.search-warn span').text('검색어를 입력하세요.');
				return;	
			}
			if(searchValue.length < 2) {
				$('.search-warn').css('display', 'block');
				$('.search-warn span').text('두 글자 이상 입력하세요.');
				return;
			}
			
			location.href='do.search.campingSite?searchValue=' + searchValue;
		  }
}