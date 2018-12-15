<%--
  Created by IntelliJ IDEA.
  User: docto
  Date: 15.12.2018
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
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
               <th>Damage</th>
               <th>Hardness</th>
               <th>Enchant</th>
           </tr>

           <j:forEach items="${tools}" var="tool">
               <tr>
                   <td><j:out value="${tool.getId()}" /></td>
                   <td><j:out value="${tool.getName()}" /></td>
                   <td><j:out value="${tool.getDamage()}" /></td>
                   <td><j:out value="${tool.getHardness()}" /></td>
                   <td><j:out value="${tool.getEnchant().getName()}" /></td>
                   <td>
                       <a href="/edit?id=${tool.getId()}">Edit</a>
                       <a href="/delete?id=${tool.getId()}">Delete</a>
                   </td>
               </tr>
           </j:forEach>

       </table>

   </div>
</body>
</html>
