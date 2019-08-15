<%--
  Created by IntelliJ IDEA.
  User: CXXRYL
  Date: 2019/8/9
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>网上书架</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <base href="<%=basepath%>"/>
    <script type="text/javascript">


        function drag(ev,bookid) {

            ev.dataTransfer.setData("bookid",bookid);
        }

        function drop(ev) {
            ev.preventDefault();

            if(confirm('你确定要删除吗')){

                var bookid = ev.dataTransfer.getData("bookid");
               // alert(bookid);
                location.href="bc/deletebook?bookid="+bookid;
            }

        }
        function allowDrop(ev) {
            ev.preventDefault();
        }

        
        function submission() {
            $("#bookform").submit();
            
        }



    </script>


</head>
<body>


<div id="book-js">

    <br/>
    <form action="/bc/tobook" method="post" id="bookform">
        <div id="booktitle"><font size="15px"><b>网上书城</b></font></div>
        <div id="booktop" style="width: 800px; position: absolute">
            <div id="bookname"> 书名:<input type="text" name="bookName" value="" style="width: 120px;height: 25px"/></div>
            <div id="lowsal"> 最低价格:<input type="text" name="lowsal" value="" style="width:50px;height: 25px"/></div>
            <div id="hisal">最高价格:<input type="text" name="hisal" value="" style="width:50px;height: 25px"/></div>
            <div id="dept">出版社:<select name="bookDept" style="height: 25px">

                <option selected="selected">全部</option>
                <option>清华大学出版社</option>
                <option>人民出版社</option>
                <option>三联出版社</option>
                <option>机械工业出版社</option>
                <option>其他</option>
            </select>
            </div>
            <div id="subm"><input type="button" onclick="submission();" value="搜索" style="height:25px "></div>

        </div>
        <div id="bookbutoom">
            <div id="pagelast">
                <input type="button" value="上一页" onclick="submission();" style="font-size: 1px"/>
            </div>

           
            <div id="pagenow">
                跳转页数:<input type="text" name="pagenow" value="${pagenow}" style="width: 45px;font-size: 1px"/>
            </div>
            <div id="pagen">
                ${pagenow}
            </div>
            <div id="pagerow">
                每页行数:<input type="text" name="pagerow" value="${pagerow}" style="width: 45px;font-size: 1px"/>
            </div>
            <div id="pagenext">
                <input type="button" value="下一页" onclick="submission();" style="font-size: 1px"/>
            </div>
        </div>
    </form>
    <%--显示页面内容--%>
    <div id="bookrack">


            <c:forEach items="${books}" var="bi">

                <a href="/bc/tobookinfo?bookid=${bi.bookid}&flag=true" title="${bi.bookName}"><img src="${bi.imgPath}" draggable="true" ondragstart="drag(event,${bi.bookid})" alt="jquery"/></a>

            </c:forEach>



    </div>

</div>
<div id="deletebook" style="position: absolute;top: 500px" ondrop="drop(event);"ondragover="allowDrop(event);" ><img src="img/jianhao.jpg" width="100"></div>
<div  style=" position:absolute;top: 500px;left: 92.9%"  ><a href="bookadd.jsp"><img src="img/jiahao.jpg" width="100"></a></div>


<link rel="stylesheet" type="text/css" href="/css/book.css"/>
<script type="text/javascript"  src="js/book.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

</body>

</html>
