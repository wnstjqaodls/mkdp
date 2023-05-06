<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>MKDP</title>
</head>
<style>
li {
padding: 1%;
margin: 1%;
}
h1 , h2 , h3 , h4 {
text-align: center;
border-bottom: 10%;
border-bottom: solid gray;
margin: 0%;
padding: 2%;
}
.mkdpConteiner {
text-align: left;
border-bottom: 10%;
border-bottom: solid gray;
margin: 0%;
padding: 2%;
}
ol {
border-right: 0.5%;
border-right: solid gray;
width: 15%;
margin: 0%;
padding: 1%;
}
</style>
<body>
<h1>
	Market Data Provider Site
</h1>
<div class="mkdpConteiner">
	Real-time Market Data at Your Fingertips <br>
	The time on the server is ${serverTime}. 
</div>
<ol>
	<li><a href="setCookie">setcookie</a></li>
	<li><a href="getCookie">getcookie</a></li>
	<li><a href="getHeader">getHeader</a></li>
	<li><a href="redirect">redirect</a></li>
	<li><a href="forward">forward</a></li>
	<li><a href="apiCall01">기업개황 apiCall</a></li>
</ol>

</body>
</html>
