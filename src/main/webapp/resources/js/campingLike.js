$(function(){

    $('.user-like-item').hover(function(){
    	// 번호 받아오기
    	let no = $(this).children('.user-hidden-input-no').val();
    	
        $('.user-like-item-img-' + no).css('opacity', '0.6');
        $('.user-visible-like-item-' + no).css('display', 'none');
        $('.user-hidden-like-item-' + no).fadeIn();
    }, function(){
    	let no = $(this).children('.user-hidden-input-no').val();
    	
        $('.user-like-item-img-' + no).css('opacity', '1');
        $('.user-hidden-like-item-' + no).css('display', 'none');
        $('.user-visible-like-item-' + no).fadeIn();
    });
    
    $('.user-like-trash').hover(function() {
    	let no = $(this).next().val();

    	$('.user-like-trash-' + no).attr('src', 'resources/camping-like/trash_click.png');
	}, function() {
		let no = $(this).next().val();
    	
		$('.user-like-trash-' + no).attr('src', 'resources/camping-like/trash.png');
	});
    
    $('.user-like-trash').click(function() {
    	// 유저 id와 사이트 번호 보내기
//    	private int cl_no;
//    	private String cl_userId;
//    	private int cl_siteNo;
		if(confirm('캠핑장을 삭제하시겠어요?')) {
			// 게시글 번호
			let cl_siteNo = $(this).next().val();
			// 유저 id
			let cl_userId = $(this).prev().val();
			
			$.ajax({
				url: "do.delete.campingSite.like",
				data: {
					"cl_siteNo" : cl_siteNo,
					"cl_userId" : cl_userId
				}
			}).done(function(data) {
				$('.user-like-item-' + cl_siteNo).remove();
				alert('캠핑장 삭제가 완료되었습니다.');
			})
			return false;
		} else {
			return false;
		}
	})
})