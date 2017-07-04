<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_tag title="Staff page">
    <jsp:body>
        <h3><fmt:message
                key="welcom" bundle="${messages}"/> ${user.firstName} ${user.secondName}</h3>
        <div class="container">
                    <form method="post" action="${pageContext.request.contextPath}/handler">
                        <c:forEach items="${patients}" var="patients">
                            <input required type="radio" name="patient" value="${patients.id}">  ${patients.firstName} ${patients.secondName}<br>
                        </c:forEach>
                        <br>
                        <c:if test="${fn:length(patients) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:if test="${fn:length(patients) gt 0}">
                            <button id="sub" type="submit" value="Select" name="select"><fmt:message key="select" bundle="${messages}"/></button>
                        </c:if>

                        <br>
                    </form>

                    <form action="logout" method="post">
                        <button type="submit"><fmt:message key="logout" bundle="${messages}"/></button>

                    </form>
        </div>
    </jsp:body>
</t:_tag>

