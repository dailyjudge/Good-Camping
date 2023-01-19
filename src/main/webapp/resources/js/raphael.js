$(function(){
   $('#button-16').click(function(){
        let visibleVal = $('#visible-input').val();
        
        if(visibleVal == 'view') {
            $('#visible-input').val('none');
            // 안보이게
            $('.map-canvas-container').css('position', 'fixed').css('left', '-800px');
            $('.camping-search-desc').css('display', 'none');
            $('.camping-theme-search-result').css('display', 'none');
        } else {
            $('#visible-input').val('view');
            $('.map-canvas-container').css('position', 'sticky').css('top', '300px');
            $('.camping-search-desc').css('display', 'block');
            $('.camping-theme-search-result').css('display', 'block');
        }

   }); 
});