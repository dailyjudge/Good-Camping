function deleteReview(no) {
	
	if(confirm('리뷰를 정말 삭제하시겠습니까?')) {
		$.ajax({
			url: "do.delete.review",
			data: {"cr_no" : no}, 
			type: "GET",
		}).done(function(res) {
			if(res == 1) {
				$('.camping-detail-' + no).remove();
				alert("리뷰가 성공적으로 삭제되었습니다.");
			}
		});
	}
	
}

function openHiddenContents(no) {
	console.log(no);
	if(confirm('리뷰를 정말 수정하시겠습니까?')) {
		$('.review-visible-' + no).css('display', 'none');
		$('.review-hidden-' + no).css('display', 'block');
	}
}

function closeHiddenContents(no) {
	console.log(no);
	if(confirm('리뷰 수정을 취소하시겠습니까?')) {
		$('.review-visible-' + no).css('display', 'block');
		$('.review-hidden-' + no).css('display', 'none');
	}
}

const drawStar = (target) => {
    document.querySelector(`.star span`).style.width = `${target.value * 10}%`;
    console.log($('#camping-review-star').val());
}

function updateReview(no) {
	if(confirm('리뷰를 정말 수정하시겠습니까?')) {
		let title = $('.review-hidden-' + no + '-title').val();
		let content = $('.review-hidden-' + no + '-content').val();
		
		$.ajax({
			url: 'do.update.review',
			data: {"cr_no" : no,
				   "cr_title" : title,
				   "cr_content" : content},
			type: "GET"	   
		}).done(function(res) {
			if(res == 1) {
				$('.review-visible-' + no + '-title').text(title);
				$('.review-visible-' + no + '-content').text(content);
				
				$('.review-visible-' + no).css('display', 'block');
				$('.review-hidden-' + no).css('display', 'none');
				alert("리뷰 수정이 완료되었습니다.");
			}
		})
	}
}

function createReview() {
	if(confirm('리뷰를 정말 등록하시겠습니까?')) {
		return true;
	} else {
		return false;
	}
}