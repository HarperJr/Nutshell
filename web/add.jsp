<%--
  Created by IntelliJ IDEA.
  User: docto
  Date: 15.12.2018
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>INSERTING</title>
</head>
<body>
<div align="center">
    <h1>Users Management</h1>
    <h2>
        <a href="/">All tools</a>
    </h2>
</div>
<div align="center">
    <form action="/insert" method="post">
        <table border="2">
            <tr>
                <td>Name</td>
                <td>Damage</td>
                <td>Hardness</td>
                <td>Enchant</td>
            </tr>
            <tr>
                <td><input type="text" name="name" value="${tool.getName()}"/></td>
                <td><input type="text" name="damage" value="${tool.getDamage()}"/></td>
                <td><input type="text" name="hardness" value="${tool.getHardness()}"/></td>
                <td><select name="enchantId">
                    <j:forEach items="${enchants}" var="enchant">
                        <option value="${enchant.getId()}"><j:out value="${enchant.getName()}" /></option>
                    </j:forEach>
                </select></td>
            </tr>
        </table>
        <br>
        <input type="submit" value="INSERT">
        </br>
    </form>
</div>
</body>
</html>