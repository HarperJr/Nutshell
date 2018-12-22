<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: docto
  Date: 22.12.2018
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<div align="center">
    <table cellpadding="5" border="2">
        <caption>
            <h2>Tools</h2>
        </caption>
        <c:url value="/insert/apply" var="insert"/>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Type</th>
        </tr>
        <tr>
            <form method="post" action="${insert}">
                <td style="border: none">
                    <input name="name" type="text" value="name" />
                </td>
                <td style="border: none">
                    <input name="type" type="text" value="type"/>
                </td>
                <td style="border: none">
                    <button type="submit">Apply</button>
                </td>
            </form>
        </tr>
    </table>
</div>

</body>
</html>

