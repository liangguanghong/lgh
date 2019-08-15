<%--
  Created by IntelliJ IDEA.
  User: CXXRYL
  Date: 2019/8/10
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上架图书</title>
</head>
<body>
<form action="bc/tobookadd" method="post" enctype="multipart/form-data">
书的名字:<input type="text" name="bookName" value="超人迪迦"/><br/>
书的出版社:<input type="text" name="bookDept" value="中国"/><br/>
书的价格:<input type="text" name="bookPrice" value="40"><br/>
书的出版日期:<input type="text" name="publicDate" value="2000-10-20"/><br/>
书的作者:<input type="text" name="bookAuth" value="本人"/><br/>
书封面:<input type="file" name="pic" value=""/><br/>
书的简介:<input type="text" name="summary" value="好好好"/><br/>
    <input type="hidden" name="flag" value="false">
    <input type="submit" value="确认">
</form>
</body>
</html>
