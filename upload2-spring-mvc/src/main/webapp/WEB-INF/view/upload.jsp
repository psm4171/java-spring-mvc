<%-- TODO #5: 파일 업로드 html form --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>file upload</title>
</head>
<body>
<%--enctype="multipart/form-data" 매우 중요 --%>
<form method="post" action="/fileUpload" enctype="multipart/form-data">
    <input type="file" name="file" /><br />
    <input type="submit" />
</form>
</body>
</html>
