<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>REGISTER (VALIDATION)</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h2>Validation RESULT</h2>
${inputRequest.name}<br>
${inputRequest.age}<br>
${inputRequest.phone}<br>
${inputRequest.email}<br>
${inputRequest.addr}<br>
</body>
</html>