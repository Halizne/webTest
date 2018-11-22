<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Index</title>
</head>
<body>
<sf:form action="${pageContext.request.contextPath}/test/add" method="post" modelAttribute="user">
    User name:<sf:input path="name"/><sf:errors path="name" /><br/>
    Password:<sf:input path="password"/><sf:errors path="password" /><br/>
    E-mail:<sf:input path="email"/><sf:errors path="email" /><br/>
    Age:<sf:input path="age"/><sf:errors path="age" /><br/>
    Birthday:<sf:input path="birthday"/><sf:errors path="birthday" /><br/>
    Address:<sf:input path="address"/><sf:errors path="address" /><br/>
    Married:
    <sf:radiobutton path="married" label="Yes" value="true"/>
    <sf:radiobutton path="married" label="No" value="false"/>
    <sf:errors path="married" /><br/>
    Likes:
    <sf:checkbox path="likes" label="Football" value="Football"/>
    <sf:checkbox path="likes" label="Badminton" value="Badminton"/>
    <sf:checkbox path="likes" label="Pingpong" value="Pingpong"/>
    <sf:errors path="likes" /><br/>
    Tel:<sf:input path="tel"/><sf:errors path="tel" /><br/>
    <input type="submit" value="Add" />
    <hr/>
    Errors:<br/><sf:errors path="*"></sf:errors>
    <hr/>
    Likes:<c:forEach items="${user.likes}" var="item">${item},</c:forEach>
</sf:form>
</body>
</html>
