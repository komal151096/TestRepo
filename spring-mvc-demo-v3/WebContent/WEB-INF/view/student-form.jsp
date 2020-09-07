<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>

<html>
<head>
<title> Student Registration Form </title>
</head>

<body>

<form:form action="processForm" modelAttribute="student">

First Name: <form:input path="firstName" /> 
<br><br>

Last Name: <form:input path="lastName"/>

<br><br>
Country:
<form:select path="country">
	<%-- <form:option value="India" label ="India" />
	<form:option value="Brazil" label ="Brazil" />
	<form:option value="Frane" label ="France" />
	<form:option value="America" label ="America" />
	<form:option value="Spain" label ="Spain" />
 --%>
 
 <form:options items="${student.countryOptions}" />
</form:select>



<br><br>

<form:radiobutton path="favouriteLanguage" value="JAVA" />
<form:radiobutton path="favouriteLanguage" value="Python" />
<form:radiobutton path="favouriteLanguage" value=".Net" />

<br><br>

<input type="submit" value="Submit">


</form:form>

</body>
</html>