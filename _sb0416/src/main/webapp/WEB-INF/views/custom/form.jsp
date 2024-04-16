<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>CUSTOM TAG PRACTICE</title>
</head>
<body>
    <p>커스텀 태그 연습</p>
    <form:form modelAttribute="formCommand">

        <p>
            <label for="loginType">로그인 타입(form:select)</label>
            <form:select path="loginType">
                <option value="">---선택---</option>
                <form:options items="${loginTypes}"/>
            </form:select>
        </p>

        <p>
<%--            <label for="loginType">로그인 타입(form:select)</label>--%>
<%--           <select name="loginType">--%>
<%--            <c:forEach var="logintype" items="${loginTypes}">--%>
<%--                <option value="${logintype}">${logintype}</option>--%>

<%--            </c:forEach>--%>
<%--           </select>--%>

<%--     <form:select path="loginType" items="${loginTypes}"/>--%>
        </p>
        <p>
            <label>선호 OS</label>
<%--            <form:checkboxes items="${favoriteOsNames}" path="favoriteOs" />--%>
        </p>
        <p>
            <label>선호 OS</label>
            <form:checkboxes path="favorite0s" items="${favorite0sCodes}"
                itemValue="Code" itemLabel="label"/>
        </p>

       <input type="submit" action="/" value="complete">
    </form:form>

</body>
</html>