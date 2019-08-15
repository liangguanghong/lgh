<%--
  Created by IntelliJ IDEA.
  User: CXXRYL
  Date: 2019/8/13
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付页面</title>
    <script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script>


       $(function(){
            $.post(
                "/ac/toCheckAccount",
                {},
                function (data) {
                    console.log(data);
                    $.each(data, function (i, n) {
                        $("#money").append("<option value='" + n.accid + "'>" + n.accid + "</option>");
                    })
                },
                "json")


        });


         function checkedmoney (accid){

                 $.ajax({
                     url: "/ac/toCheckBalance",
                     type: "POST",
                     dataType: "json",
                     data: {
                       "accid":accid
                     },
                     success: function (data) {
                         $("#mybalance").html(data);
                         console.log(data);

                     },
                 });


             }
    function updatebook(state) {
        var booknum=parseInt($('#booknum').html());
             if (state=="jia"){

                 booknum=booknum+1
             }
        if (state=="jian"){
            if (booknum<1){

            }else {
                booknum=booknum-1
            }

        }

         $('#booknum').html(booknum);
        document.getElementById("inputbooknum").value=booknum;


    }

    </script>
</head>
<body>

<form action="/shc/tobuybook" method="post">
    书名:${book.bookName}<br/>
    书的价格:${book.bookPrice}<br/>
    书的数量:<a href="javascript:updatebook('jian')">-</a><div style="display: inline-block" id="booknum">1</div><a href="javascript:updatebook('jia')">+</a><br/>
    <input  type="hidden" name="bookid" value="${book.bookid}">
    <input type="hidden" name="bookPrice" value="${book.bookPrice}">
    <input id="inputbooknum" type="hidden" name="booknum" value="1">
    用户:${myuser.realname}<br/>账户:<select id="money" name="accid" onchange="checkedmoney(this.value);">
    <option value=0>--请选择你的账户--</option>


</select>
    余额：<span id="mybalance"></span><br/>
    <input type="submit" value="支付">
</form>


</body>
</html>
