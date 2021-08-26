$("#submit").click(function () {

	$(".contact_message_sent").show();
	setTimeout(function () {
		$('.contact_message_sent').fadeOut();
	}, 1000);
	
});