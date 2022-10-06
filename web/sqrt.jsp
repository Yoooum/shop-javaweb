<%--
  Created by IntelliJ IDEA.
  User: Yoooum
  Date: 2022/9/15
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>square</title>
</head>
<%! String data;
    private double sqrt(double num) {
        return Math.sqrt(num);
    }
%>

<body>

<form action="#" method="post">
    <label>
        <input type="text" name="data">
        <input type="submit" value="计算">
    </label>
</form>

<% data = request.getParameter("data");
    if (data != null) {
        out.print(sqrt(Double.parseDouble(data)));
    }
%>

</body>
</html>