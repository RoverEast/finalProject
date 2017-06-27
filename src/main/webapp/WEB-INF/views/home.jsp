<%--@elvariable id="password" type=""--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 27.05.2017
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Welcome ${user.firstName} ${user.secondName}</title>
</head>
<body>
    <table>
        <tr>
            Welcome ${user.firstName} ${user.secondName}
        </tr>

    </table>
</body>
</html>
