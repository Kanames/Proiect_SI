<!-- REGISTRATION FORM -->
<div class="text-center" style="padding:50px 0">
	<div class="logo">register</div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form id="register-form" class="text-left" action="../../BE_development/PHP/FlowDecisions/flow04Register.php">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group">
						<label for="reg_username" class="sr-only">Email address</label>
						<input type="text" class="form-control" id="reg_username" name="reg_username" placeholder="nickname" required pattern=".{3,}"   title="Trebuie sa contina min 3 caractere" required>
					</div>
					<div class="form-group">
						<label for="reg_password" class="sr-only">Password</label>
						<input type="password" class="form-control" id="reg_password" name="reg_password" placeholder="password" maxlength=15" pattern=".{5,15}" title="Parola trebuie sa aiba min 5 si maxim 15 caractere" required >
					</div>
					<div class="form-group">
						<label for="reg_password_confirm" class="sr-only">Password Confirm</label>
						<input type="password" class="form-control" id="reg_password_confirm" name="reg_password_confirm" placeholder="confirm password" maxlength=15" pattern=".{5,15}" title="Parola trebuie sa aiba min 5 si maxim 15 caractere" required >
					</div>

					<div class="form-group">
						<label for="reg_email" class="sr-only">Email</label>
						<input type="text" class="form-control" id="reg_email" name="reg_email" placeholder="email" pattern=".{7,}"   title="Trebuie sa contina min 7 caractere" required>
					</div>
					<div class="form-group">
						<label for="reg_fullname" class="sr-only">Full Name</label>
						<input type="text" class="form-control" id="reg_fullname" name="reg_fullname" placeholder="full name"  pattern=".{5,}"   title="Trebuie sa contina min 5 caractere" required>
					</div>

					<div class="form-group login-group-checkbox">
						<input type="radio" class="" name="reg_gender" id="male" placeholder="username" value="M">
						<label for="male">male</label>

						<input type="radio" class="" name="reg_gender" id="female" placeholder="username"  value="F">
						<label for="female">female</label>
					</div>

					<div class="form-group login-group-checkbox">
						<input type="checkbox" class="" id="reg_agree" name="reg_agree">
						<label for="reg_agree">i agree with <a href="#">terms</a></label>
					</div>
				</div>
				<button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
			</div>
			<div class="etc-login-form">
				<p>already have an account? <a href="BackPagina01.jsp">login here</a></p>
			</div>
		</form>
	</div>
	<!-- end:Main Form -->
</div>