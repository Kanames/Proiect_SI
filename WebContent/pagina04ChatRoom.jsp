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
        <button class="btn">Send</button>
    </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
function update()
{
    $('.chatlogs').children().last().focus();
    $.post("ActionServlet", { nrmesaje:$(".chatlogs").children().length},
        function(responseText){
            $('.chatlogs').append(responseText);
        });
    setTimeout('update()', 1000);
}
	$(document).ready(function() {
		$('.btn').click(function(event) {
			update();
			var mesajScris = $('#mesajScris').val();
			$.post('ActionServlet', {
				user : mesajScris
			}, function(responseText) {
				  $('.chatlogs').append(responseText);
			});
			 if($.trim($("#mesajScris").val())) {
		            $('.chatlogs').append('<div class="chat self"><div class="user-photo"><img src="https://f4.bcbits.com/img/0009587045_10.jpg"></div>\n' +
		                '<p class="chat-msg"> '+$('#mesajScris').val()
		                + '</p>'+'</div>');
		            golestMesajScris();
		        }
		});
	});
	
	function golestMesajScris() {
		document.getElementById("mesajScris").value = '';
	}
</script>