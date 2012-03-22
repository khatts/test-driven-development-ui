$(document).ready(function() {
	$('#equities').tabs({ selected: 0});
	checkUserPrivilege();
	$('#equities').bind('tabsselect',function(e, ui) {
       if(ui.index == 0){
    	   loadOrders();
       }else{
    	   loadBlotters();
       }
    });
   $("a[id^='logout']" ).click(function(){
		$(window).unbind();
	});
	
});
function loadOrders(){
	 $.ajax({
			type: "GET",
	        url: "/tdd/equity/order/create",
	        success: function(data) {
	        	$('#orders').html(data);
	        	$('#blotters').html("");
	    	}
		});
}
function loadBlotters(){
	$.ajax({
		type: "GET",
        url: "/tdd/equity/blotter",
        success: function(data) {
        	$('#blotters').html(data);
        	$('#orders').html("");
    	}
	});
}
function checkUserPrivilege(){
	$.ajax({
		type: "GET",
        url: "/tdd/equity/privilege",
        datatype:"json",
        success: function(data) {
        		var privileges =[];
        		var canUserCreateOrder=false;
        		privileges= jQuery.parseJSON(data);
        		for(var i=0;i<privileges.length;i++){
            		if(privileges[i].name == "PortfolioManageAccess"){
            			canUserCreateOrder = true;
            		}
            }
        	if(!canUserCreateOrder){
        			$("#equities").tabs("remove","#orders");
        			loadBlotters();
        	}else{
        		loadOrders();
        	}
        }
	});
}


