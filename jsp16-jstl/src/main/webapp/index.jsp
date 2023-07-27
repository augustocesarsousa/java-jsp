<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>JSTL</title>
  </head>
  <body>
    <h1>Curso JSP - JSTL</h1>
    <% String[] frutas = new String[4]; frutas[0] = "Abacate"; frutas[1] =
    "Banana"; frutas[2] = "Laranja"; frutas[3] = "Uva";
    request.setAttribute("frutas", frutas); %>
    <ul>
      <c:forEach items="${frutas}" var="fruta">
        <li><c:out value="${fruta}"></c:out></li>
      </c:forEach>
    </ul>
  </body>
</html>
