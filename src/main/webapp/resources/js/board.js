$(function(){
	
	function whereSearch(){
		
		var whereToSearch = document.getElementById("whereToSearch").val(); 
		
	    $.ajax({
	    	url: "go.search.where",
	    	data: {
	    		"comu_groupid" : whereToSearch
	    	}
	    }).done(function(res) {
			
			if(res == 0) {
				alert("성공");
			} else {
				alert("실패");
			}
		});
		
	}
	
	
	
});

	