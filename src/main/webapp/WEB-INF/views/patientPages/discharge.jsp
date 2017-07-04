<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_tag title="Dicharge">
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
    </jsp:body>
</t:_tag>



