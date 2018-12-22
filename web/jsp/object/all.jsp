<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: docto
  Date: 22.12.2018
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All</title>
</head>
<body>
<div align="center">

    <table cellpadding="5" border="2">
        <caption>
            <h2>Tools</h2>
        </caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Type</th>
        </tr>

        <c:forEach items="${objects}" var="object">
            <tr>
                <td><c:out value="${object.getId()}" /></td>
                <td><c:out value="${object.getName()}" /></td>
                <td><c:out value="${object.getType()}" /></td>
                <td style="border: none">
                    <c:url value="/edit/${object.getId()}" var="edit" />
                    <a href="${edit}">Edit</a>
                    <c:url value="/delete/${object.getId()}" var="delete" />
                    <a href="${delete}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:url value="/insert" var="insert"/>
    <a href="${insert}">Add new</a>
</div>
</body>
</html>

