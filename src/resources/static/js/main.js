"use strict";

$(function() {
 
	// return to top of the page
    NProgress.start();

    $(window).scroll(function(){  // as window scroll
        var scrollt = document.documentElement.scrollTop + document.body.scrollTop; 
        if( scrollt >200 ){ 
            $("#goToTop").fadeIn(400); 
        }else{
            $("#goToTop").stop().fadeOut(400); 
        }
    });
    $("#goToTop").click(function(){ 
        $("html,body").animate({scrollTop:"0px"},200);
    });
    NProgress.done();
});