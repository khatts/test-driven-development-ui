$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "/tdd/equity/order/symbols",
        dataType: "json",
        success: function(data) {
        	var datafromServer=[];
        	for(var i=0;i<data.length;i++){
        		 datafromServer[datafromServer.length] = data[i].name;
        	}
            $("[id$='symbol']").autocomplete({
                source: datafromServer,
                select: function(event, ui) {
                	var symbol = ui.item.value;
                	 $.ajax({
                	        type: "GET",
                	        url: "/tdd/equity/order/symbol/security",
                	        dataType: "json",
                	        data: {'symbol': symbol },
                	        success: function(data) {
                				$('input[name="securityName"]').val(data);
                	        }
                	 });
                }
            });
        },
    });
    $( "div[id^='dialog-form']" ).dialog({
    	autoOpen: false,
    	height: 180,
    	width: 350,
    	modal: true,
    	buttons: {
    		"Save": function() {
    			var portfolioName=$('input[id^="portfolioName"]').val();
    			var opt = "<option selected ='true' value='"+ portfolioName + "'>" + portfolioName + "</option>";
    			$('select[name="portfolio.name"]').prepend(opt);
    			portfolioName.value="";
    			$( this ).dialog( "close" );
    		}
    	}
    });
});
$('select[name="subAccount.name"]').change(function(){
	var selectedVal = $("select option:selected").val();
	$.ajax({
		type: "GET",
        url: "/tdd/equity/order/subAccount/portfolio",
        dataType: "json",
        data: {'subAccount': selectedVal },
        success: function(data) {
			$('select[name="portfolio.name"]').val("");
			$('select[name="portfolio.name"]').text("");
			for(var i=0;i<data[0].portfolios.length;i++){
				var opt = "<option value='"+ data[0].portfolios[i] + "'>" + data[0].portfolios[i] + "</option>";
				$('select[name="portfolio.name"]').append(opt);
			}
        }
	});
	
});
$("#addPortfolio").click(function(){
	$( "#dialog-form" ).dialog( "open" );
	return false;
	
});
$("#Save").click(function(e){
		$.ajax({
			type: "POST",
	        url: "/tdd/equity/order/create",
	        data: $('form[name="createOrder"]').serializeArray(),
	        success: function(data) {
				$("#orderTable").html(data);
	        }
		});
		
});
$(window).bind('beforeunload', function() {
	return 'You have made changes on this page that you have not yet confirmed.';
});