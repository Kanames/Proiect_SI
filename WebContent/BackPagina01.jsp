<html>
	<head>
		<!-- Required meta -->
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="author" content="Paladuta Stefan">
    	<meta name="description" content="Proiect PIE, CTI ANUL 4">
   		<link rel="icon" href="web_pictures/tabIcon.ico">
        <title>SayHi Login</title>
    	<!-- Bootstrap -->
    	<link href="lib_frameworkuri/Bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles -->
        <link href="lib_frameworkuri/Bootstrap/cover.css" rel="stylesheet">
        <link href="lib_frameworkuri/FontAwesome/css/font-awesome.min.css" rel="stylesheet">
	</head>
	<body>
	 <div class="site-wrapper">
         <div class="site-wrapper-inner">
             <div class="cover-container">
                 <!--  include navigation bar -->
                 <jsp:include page="navBar.jsp"/>
                 <div class="inner cover">
                     <div class="container">
                         <div class="row">
                             <div class="col-md-12">
                                 <!--  include form -->
                                  <jsp:include page="pagina01Login.jsp"/>
                             </div>
                         </div>
                     </div>
                 </div>
                 <!--  include footer bar -->
                 <jsp:include page="footerBar.html"/>

             </div>
         </div>
     </div>
     <!-- Bootstrap core JavaScript .min.js && .js
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="lib_frameworkuri/Bootstrap/js/bootstrap.js"></script>
    <script src="lib_frameworkuri/Bootstrap/js/jquery.min.js"></script>
    <script src="lib_frameworkuri/Bootstrap/js/bootstrap.min.js"></script>
    <script src="lib_frameworkuri/Bootstrap/form.js"></script>
	</body>
	
</html>