/*!
 * index main JS.
 */
"use strict";
//# sourceURL=index.js

// Execute after DOM lodaing
$(function() {
    
	var _pageSize;
	
	// get blog lists
	function getBlogsByName(pageIndex, pageSize) {
		 $.ajax({ 
			 url: "/blogs", 
			 contentType : 'application/json',
			 data:{
				 "async":true, 
				 "pageIndex":pageIndex,
				 "pageSize":pageSize,
				 "keyword":$("#indexkeyword").val()
			 },
			 success: function(data){
				 $("#mainContainer").html(data);
				 
				 var keyword = $("#indexkeyword").val();
				 
				 if (keyword.length > 0) {
					$(".nav-item .nav-link").removeClass("active");
				 }
		     },
		     error : function() {
		    	 toastr.error("error!");
		     }
		 });
	}
	

	$.tbpage("#mainContainer", function (pageIndex, pageSize) {
		getBlogsByName(pageIndex, pageSize);
		_pageSize = pageSize;
	});
   
	// keyword search
	$("#indexsearch").click(function() {
		getBlogsByName(0, _pageSize);
	});
	
	
	$(".nav-item .nav-link").click(function() {
 
		var url = $(this).attr("url");
		
		
		$(".nav-item .nav-link").removeClass("active");
		$(this).addClass("active");  
 
		
		 $.ajax({ 
			 url: url+'&async=true', 
			 success: function(data){
				 $("#mainContainer").html(data);
			 },
			 error : function() {
				 toastr.error("error!");
			 }
		 })
		 
		
		 $("#indexkeyword").val('');
	});
 
 
});