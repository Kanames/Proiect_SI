<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
	  <div class="login-form-1">
		<form id="login-form" class="text-left" action="Login" METHOD="POST" >
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group">
						<label for="lg_username" class="sr-only">Username</label>
						<input type="text" class="form-control" id="lg_username" name="tmp_username" placeholder="username or email" pattern=".{3,}"   title="Trebuie sa contina min 3 caractere" >
					</div>
					<div class="form-group">
						<label for="lg_password" class="sr-only">Password</label>
						<input type="password" class="form-control" id="lg_password" name="tmp_password" placeholder="password" maxlength=15" pattern=".{5,15}" title="Parola trebuie sa aiba min 5 si maxim 15 caractere"  >
					</div>
					<div class="form-group login-group-checkbox">
						<input type="checkbox" id="lg_remember" name="tmp_remember">
						<label for="lg_remember">remember</label>
					</div>
				</div>
				<button type="submit" class="login-button">
				        <i class="fa fa-chevron-right"></i>
				</button>
			</div>
			<div class="etc-login-form">
				<p>forgot your password? <a href="BackPagina06.jsp">click here</a></p>
				<p>new user? <a href="BackPagina05.jsp">create new account</a></p>
			</div>
		</form>
      </div>
    </div>
    <div class="col-sm-3"></div>
</div>