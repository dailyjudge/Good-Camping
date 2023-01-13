function searchToggle(obj, evt){
    var container = $(obj).closest('.search-wrapper');
        if(!container.hasClass('active')){
            container.addClass('active');
            evt.preventDefault();
        }
        else if(container.hasClass('active') && $(obj).closest('.input-holder').length == 0){
            container.removeClass('active');
            // clear input
            container.find('.search-input').val('');
        }
}

function enterkey() {
	  if (window.event.keyCode == 13) {
			
			let searchValue = $('.search-input').val();
			
			location.href='do.search.campingSite?searchValue=' + searchValue;
		  }
}