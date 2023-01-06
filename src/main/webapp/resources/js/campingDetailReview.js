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

function openHiddenContents(no, star) {
	console.log(no);
	if(confirm('리뷰를 정말 수정하시겠습니까?')) {
		$('.review-visible-' + no).css('display', 'none');
		$('.review-hidden-' + no).css('display', 'block');
		$('.review-hidden-category-' + no).css('display','block');
		$('.star-hidden-' + no).css('display', 'block');
		
		$('.star-hidden-' + no + ' span').css('width', star * 20 + '%');
	}
}

function closeHiddenContents(no) {
	console.log(no);
	if(confirm('리뷰 수정을 취소하시겠습니까?')) {
		$('.review-visible-' + no).css('display', 'block');
		$('.review-hidden-' + no).css('display', 'none');
	}
}

// 별점 관련 이벤트
const drawStar = (target) => {
    document.querySelector(`.star span`).style.width = `${target.value * 10}%`;
    
    console.log(target.value);
}

const drawStar2 = (target) => {
	let className = $(target).attr('class');
	//27
	no = className.slice(className.length - 2, className.length);
	
	document.querySelector('.star-hidden-' + no + ' span').style.width = `${target.value * 10}%`;
}

function updateReview(no) {
	if(confirm('리뷰를 정말 수정하시겠습니까?')) {
		// 변경된 내용
		let title = $('.review-hidden-' + no + '-title').val();
		let content = $('.review-hidden-' + no + '-content').val();
		let star = $('.camping-review-star-' + no).val() / 2;
		star = star.toFixed(1);
		
		// 기존 내용
		let originTitle = $('.review-visible-' + no + '-title').text();
		let originContent = $('.review-visible-' + no + '-content').text();
		let originStar = $('.camping-review-star-origin-' + no).val();
		
		// 입력된 내용이 없다면
		if(title == "") {
			alert('제목을 입력하세요.');
			$('.review-hidden-' + no + '-title').focus();
			return;
		}
		if(content == "") {
			alert('내용을 입력하세요.');
			$('.review-hidden-' + no + '-content').focus();
			return;
		}
		// 기존 데이터와 같다면
		if(originTitle == title && originContent == content && originStar == star) {
			aletr('변경된 내용이 없습니다.');
			$('.review-hidden-' + no + '-title').focus();
			return;
		}
		
		$.ajax({
			url: 'do.update.review',
			data: {"cr_no" : no,
				   "cr_title" : title,
				   "cr_content" : content,
				   "cr_star" : star},
			type: "GET"	   
		}).done(function(res) {
			if(res == 1) {
				$('.review-visible-' + no + '-title').text(title);
				$('.review-visible-' + no + '-content').text(content);
				
				$('.review-visible-' + no).css('display', 'block');
				$('.review-hidden-' + no).css('display', 'none');
				
				$('.review-hidden-category-' + no).css('display','none');
				$('.star-hidden-' + no).css('display', 'none');
				
				// 값 변경
				$('.review-user-star-' + no).text(star);
				// 사진 변경
				$('.camping-content-star-img-' + no).attr("src", "resources/star/star-" + star + ".jpeg");
				$('.star-hidden-' + no + ' span').css('width', star * 20 + '%');
				
				
				
				
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