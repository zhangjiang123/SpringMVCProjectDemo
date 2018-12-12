<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>

    <script src="js/jquery.min.js"></script>

    <script>
        $(function () {
            $("#btn").click(function () {
                // alert("hello btn")

                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"hehe","password":"123","age":18}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }

                });

            });
        });
    </script>
</head>
<body>
        <a href="user/testString">testString</a>

        <a href="user/testVoid">testVoid</a><br/>

        <a href="user/testModelandView">testModelandView</a><br/>

        <a href="user/testForwardAndRedirect">testForwardAndRedirect</a><br/>

        <button id="btn">发送ajax请求</button><br/>
</body>
</html>
