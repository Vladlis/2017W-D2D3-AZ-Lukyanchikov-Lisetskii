<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Admin Home</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="/admin/upload">
    <label>File to upload:
        <input type="file" name="file"/>
    </label>
    <input type="submit" value="Upload"/>
</form>
<br>
<c:if test="${isLogoUploaded}">
    <a href="/admin/logo">Download Logo</a>
</c:if>
<br>
<a href="/logout">Logout</a>
</body>
</html>
