<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_tag title="Checkup patient">
    <jsp:body>
        <table>
            <tr>
                <td>
                    <form action="handler" method="post" class="checkTable">
                        <input type="hidden" name="patient" value="${patient.id}">
                        <fmt:message key="mixture" bundle="${messages}"/><br>
                        <c:forEach items="${mixturesList}" var="mixturesList">
                            <input id="myDiv" required type="radio" name="mixture" value="${mixturesList.id}" > ${mixturesList.name}<br>
                        </c:forEach>
                        <c:if test="${fn:length(mixturesList) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:if test="${fn:length(mixturesList) gt 0}">
                            <button type="submit" name="healMixture"><fmt:message key="do" bundle="${messages}"/></button>
                        </c:if>                    </form>
                </td>

                <td>
                    <form action="handler" method="post" class="checkTable">
                        <input type="hidden" name="patient" value="${patient.id}">
                        <fmt:message key="procedure" bundle="${messages}"/><br>
                        <c:forEach items="${proceduresList}" var="proceduresList">
                            <input id="myDiv" required type="radio" name="procedure" value="${proceduresList.id}" > ${proceduresList.name}<br>
                        </c:forEach>
                        <c:if test="${fn:length(proceduresList) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:if test="${fn:length(proceduresList) gt 0}">
                            <button  type="submit" name="healProcedure"><fmt:message key="do" bundle="${messages}"/></button>
                        </c:if>                    </form>
                </td>
            </tr>
        </table>
        <button onclick="toStaffPage()">Cancel</button>
    </jsp:body>
</t:_tag>


