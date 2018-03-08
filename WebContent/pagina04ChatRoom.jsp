<link rel="stylesheet" type="text/css" href="lib_frameworkuri/style.css">
<div class = "chatbox">
    <div class="chatlogs">
        <div class="chat friend">
            <div class="user-photo"><img src="https://f4.bcbits.com/img/0004402976_10.jpg"></div>
            <p class="chat-msg">Type: SayHi</p>
        </div>

<!--        <div class="chat self">-->
<!--            <div class="user-photo"></div>-->
<!--            <p class="chat-msg">SayHi</php></p>-->
<!--        </div>-->

    </div>
    <div class="chat-form">
        <textarea id="mesajScris"></textarea>
        <button class="btn" onclick="doAjaxAd()">Send</button>
    </div>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
	<script type="text/javascript">

function doAjaxAd() {
		var mesajScris = $('#mesajScris').val();
		 if($.trim($("#mesajScris").val())) {
	         $('.chatlogs').append('<div class="chat self"><div class="user-photo"><img src="https://f4.bcbits.com/img/0009587045_10.jpg"></div>\n' +
	             '<p class="chat-msg"> '+$('#mesajScris').val()
	             + '</p>'+'</div>');
	         golestMesajScris();
	     }
		$.ajax({
			async : "false",
			type : "post",
			url : "ActionServlet", 
			data : {
				user : mesajScris
			},
			success : function(data) {
				 $(".chatlogs").append(data);
			},
			complete : function(data) {
				setTimeout("doAjax()", 500);
			}
		});
}	
	
	
	
function doAjax() {
	$.ajax({
		type : "post",
		url : "ActionServlet", 
		success : function(data) {
			 $(".chatlogs").append(data);
		},
		complete : function(data) {
			setTimeout("doAjax()", 500);
		}
	});
}

	
	function golestMesajScris() {
		document.getElementById("mesajScris").value = '';
	}
</script>