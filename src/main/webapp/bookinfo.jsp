<%@ page import="cn.sz.lgh.pojo.Book" %><%--
  Created by IntelliJ IDEA.
  User: CXXRYL
  Date: 2019/8/9
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>书的简介</title>
</head>
<body>
<table cellspacing="0" border="1" width="500px">
    <tr>
        <td colspan="2" align="center">图书信息</td>
    </tr>
    <tr>
        <td width="100px" td align="center">
            书的编号:
        </td>
        <td width="100px">
            ${book.bookid}
        </td>
    </tr>


    <tr>
        <td align="center">
            书名
        </td>
        <td width="100px">
            ${book.bookName}
        </td>
    </tr>
    <tr>
        <td align="center">
            出版社
        </td>
        <td>
            ${book.bookDept}
        </td>
    </tr>
    <tr>
        <td align="center">
            销售价格
        </td>
        <td>
            ${book.bookPrice}
        </td>
    </tr>
    <tr>
        <td align="center">
        出版日期
        </td>
    <td>
        ${book.publicDate}
    </td>
    </tr>
    <tr>
        <td align="center">
            书的作者
        </td>
        <td>
            ${book.bookAuth}
        </td>
    </tr>
    <tr>
        <td align="center">
            图书封面
        </td>
        <td>
            <img src="/${book.imgPath}" width="200"/>
        </td>
    </tr>
    <tr>
        <td align="center">
            简介
        </td>
        <td>
            ${book.summary}
        </td>
    </tr>



</table>
<div ${flag==false?"style='display:none'":""} }><input type="button" value="购买" onclick="javascript:location.href='/bc/topay?bookid=${book.bookid}'"></div>

<input type="button" value="返回" onclick="javascript:location='/bc/tobook'">


</body>
</html>
