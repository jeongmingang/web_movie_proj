<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		$( document ).ready( function() {
		  var hClass = $( 'h1' ).attr( 'class' );
		  $( '.non span' ).text( hClass );
		} );
	</script>
</head>
<body>
	<h1 class="active">Lorem ipsum dolor.</h1>
    <p class="non">h1 class value is : <span></span></p>
</body>
</html>