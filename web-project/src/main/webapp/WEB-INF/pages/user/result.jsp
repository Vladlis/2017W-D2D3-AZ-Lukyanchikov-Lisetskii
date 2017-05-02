<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>User Home</title>
</head>
<body>
<c:choose>
    <c:when test="${result == null}">
        Not found.
    </c:when>
    <c:otherwise>
        Result: ${result}
    </c:otherwise>
</c:choose>
</body>
</html>
