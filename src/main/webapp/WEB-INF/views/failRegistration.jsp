<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 28.05.2017
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>

<t:_tag>
    <jsp:body>
        <fmt:message
                key="failRegistration" bundle="${messages}"/><br>
        <form action="/registration" method="get">
            <button onclick="toRegistration()"><fmt:message key="back" bundle="${messages}"/></button>

        </form>

        <script>
            function toMain() {
                location.href = "${pageContext.request.contextPath}/registration";
            }
        </script>
    </jsp:body>
</t:_tag>


