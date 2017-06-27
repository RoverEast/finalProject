<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 13.06.2017
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>

<t:_tag>
    <jsp:body>

        <h3><fmt:message
                key="welcom" bundle="${messages}"/> ${user.firstName} ${user.secondName}</h3>
        <form action="patient" method="post">
            <table>
                <tr>
                    <td>
                        <fmt:message key="diagnosis" bundle="${messages}"/>
                    </td>
                    <td>
                        <c:forEach items="${sickList}" var="sickList">
                            ${sickList.name}
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td>
                    </td>
                    <td>
                        <button onclick="toMain" type="submit" name="ok" value="Submit"><fmt:message key="submit" bundle="${messages}"/></button>
                    </td>
                </tr>
            </table>
        </form>
        <script>
            function toMain() {
                location.href = "${pageContext.request.contextPath}/login";
            }
        </script>
    </jsp:body>
</t:_tag>



