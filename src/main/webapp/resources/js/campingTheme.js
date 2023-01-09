$(function(){
    $('.theme-item-container').click(function(){
        let curSrc = $(this).children('img').attr('src');

        // 클릭이 된 상태라면
        if(curSrc.includes('click')) {
            curSrc = curSrc.slice(0, curSrc.length - 10) + ".png"

            // 이미지 처리
            $(this).children('img').attr('src', curSrc);

            // 글자색 변경
            $(this).children('span').css('color', 'black')
            
            // 배경 border
            $(this).css('border', '2px solid #fff');
        } else {
            curSrc = curSrc.slice(0, curSrc.length - 4) + "_click.png";
            
            // 이미지 처리
            $(this).children('img').attr('src', curSrc);

            // 글자색 변경
            $(this).children('span').css('color', '#8ec3b0')
            
            // 배경 border
            $(this).css('border', '2px solid #8ec3b0');
        }
    });
});