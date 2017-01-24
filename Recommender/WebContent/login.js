$(document).ready(
		
		function() {

			$("#login").click(
					function(e) {
						dataString = $("#loginform").serialize();
						var username = $("input#username").val();
						var password = $("input#password").val();
						if (username == '' || password == '') {
							$('input[type="text"],input[type="password"]').css(
									"border", "2px solid red");
							$('input[type="text"],input[type="password"]').css(
									"box-shadow", "0 0 3px red");
							alert("Please fill all fields.");
							return false;
						} else {
							return true;
						}/*else {
							$.post({
								url : "UsersServlet",
								data : dataString,
								success : function(data) {
									
								}
							});
						}*/

					});
		});