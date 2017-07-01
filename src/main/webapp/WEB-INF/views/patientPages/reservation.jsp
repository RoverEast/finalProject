<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_tag title="Reservation">
    <jsp:body>
        <form method="post" action="${pageContext.request.contextPath}/reservation" class="signin">
            <h3><fmt:message key="appointment" bundle="${messages}"/></h3>
            <table class="textDataReserv">
                <tr>
                    <td>
                        <fmt:message key="doctor" bundle="${messages}"/>:
                    </td>
                    <td>
                        <c:if test="${fn:length(docList) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:forEach items="${docList}" var="docList">
                            <input required type="radio" name="doc"
                                   value="${docList.id}"> ${docList.firstName} ${docList.secondName}<br>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td >
                        <hr>
                    </td>
                    <td>
                        <hr>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fmt:message key="nurse" bundle="${messages}"/>:
                    </td>
                    <td>
                        <c:if test="${fn:length(nurseList) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:forEach items="${nurseList}" var="nurseList">
                            <input required type="radio" name="nurse"
                                   value="${nurseList.id}"> ${nurseList.firstName} ${nurseList.secondName}<br>
                        </c:forEach>
                    </td>
                </tr>
            </table>
            <c:if test="${fn:length(docList) gt 0 and fn:length(nurseList) gt 0}">
            <button type="submit" name="reserv"><fmt:message key="enroll"
            bundle="${messages}"/></button>
        </c:if>
            <c:if test="${fn:length(docList) eq 0 or fn:length(nurseList) eq 0}">
            <fmt:message key="StuffIsBusy" bundle="${messages}"/>
        </c:if>
            <br>
        </form>
    </jsp:body>
</t:_tag>

