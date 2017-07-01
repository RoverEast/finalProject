<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_tag title="Checkup patient">
    <jsp:body>
        <input type="hidden" name="patient" value="${patient.id}">
        <span id="message">${message}</span>
        <button id="dischargeButton" onclick="loadXMLDoc()" onclick="this.disabled=true"><fmt:message key="discharge" bundle="${messages}"/></button>
        <table>
            <tr>
                <td>
                    <form action="handler" method="post" class="checkTable">
                        <input type="hidden" name="patient" value="${patient.id}">
                        <fmt:message key="sick" bundle="${messages}"/><br>
                        <c:forEach items="${sicks}" var="sicks">
                            <input required type="radio" name="sick" value="${sicks.id}" > ${sicks.name}<br>
                        </c:forEach>
                        <c:if test="${fn:length(sicks) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:if test="${fn:length(sicks) gt 0}">
                        <button onclick="reload()" type="submit" name="addSick"><fmt:message key="add" bundle="${messages}"/></button>
                        </c:if>
                    </form>
                </td>

                <td>
                    <form action="handler" method="post" class="checkTable">
                        <input type="hidden" name="patient" value="${patient.id}">
                        <fmt:message key="mixture" bundle="${messages}"/><br>
                        <c:forEach items="${mixtures}" var="mixtures">
                            <input required type="radio" name="mixture" value="${mixtures.id}" > ${mixtures.name}<br>
                        </c:forEach>
                        <c:if test="${fn:length(mixtures) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:if test="${fn:length(mixtures) gt 0}">
                        <button type="submit" name="addMixture"><fmt:message key="add" bundle="${messages}"/></button>
                        </c:if>
                    </form>
                </td>

                <td>
                    <form action="handler" method="post" class="checkTable">
                        <input type="hidden" name="patient" value="${patient.id}">
                        <fmt:message key="procedure" bundle="${messages}"/><br>
                        <c:forEach items="${procedures}" var="procedures">
                            <input required type="radio" name="procedure" value="${procedures.id}" > ${procedures.name}<br>
                        </c:forEach>
                        <c:if test="${fn:length(procedures) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:if test="${fn:length(procedures) gt 0}">
                        <button type="submit" name="addProcedure"><fmt:message key="add" bundle="${messages}"/></button>
                        </c:if>
                    </form>
                </td>

                <td>
                    <form action="handler" method="post" class="checkTable">
                        <input type="hidden" name="patient" value="${patient.id}">
                        <fmt:message key="operation" bundle="${messages}"/><br>
                        <c:forEach items="${operations}" var="operations">
                            <input required type="radio" name="operations" value="${operations.id}" > ${operations.name}<br>
                        </c:forEach>
                        <c:if test="${fn:length(operations) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:if test="${fn:length(operations) gt 0}">
                        <button type="submit" name="addOperations"><fmt:message key="add" bundle="${messages}"/></button>
                        </c:if>
                    </form>
                </td>
            </tr>


            <tr>
                <td>
                    <form action="handler" method="post" class="checkTable">
                        <input type="hidden" name="patient" value="${patient.id}">
                        <c:forEach items="${sickList}" var="sickList">
                            <input required type="radio" name="sick" value="${sickList.id}" > ${sickList.name}<br>
                        </c:forEach>
                        <c:if test="${fn:length(sickList) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:if test="${fn:length(sickList) gt 0}">
                        <button ck="reload()" type="submit" name="healSick"><fmt:message key="do" bundle="${messages}"/></button>
                        </c:if>
                    </form>
                </td>

                <td>
                    <form action="handler" method="post" class="checkTable">
                        <input type="hidden" name="patient" value="${patient.id}">
                        <c:forEach items="${mixturesList}" var="mixturesList">
                            <input required type="radio" name="mixture" value="${mixturesList.id}" > ${mixturesList.name}<br>
                        </c:forEach>
                        <c:if test="${fn:length(mixturesList) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:if test="${fn:length(mixturesList) gt 0}">
                        <button type="submit" name="healMixture"><fmt:message key="do" bundle="${messages}"/></button>
                        </c:if>
                    </form>
                </td>

                <td>
                    <form action="handler" method="post" class="checkTable">
                        <input type="hidden" name="patient" value="${patient.id}">
                        <c:forEach items="${proceduresList}" var="proceduresList">
                            <input required type="radio" name="procedure" value="${proceduresList.id}" > ${proceduresList.name}<br>
                        </c:forEach>
                        <c:if test="${fn:length(proceduresList) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:if test="${fn:length(proceduresList) gt 0}">
                        <button type="submit" name="healProcedure"><fmt:message key="do" bundle="${messages}"/></button>
                        </c:if>
                    </form>
                </td>

                <td>
                    <form action="handler" method="post" class="checkTable">
                        <input type="hidden" name="patient" value="${patient.id}">
                        <c:forEach items="${operationsList}" var="operationsList">
                            <input required type="radio" name="operations" value="${operationsList.id}" > ${operationsList.name}<br>
                        </c:forEach>
                        <c:if test="${fn:length(operationsList) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:if test="${fn:length(operationsList) gt 0}">
                        <button type="submit" name="healOperations"><fmt:message key="do" bundle="${messages}"/></button>
                        </c:if>
                    </form>
                </td>

            </tr>
        </table>
        <button onclick="toMain()">Cancel</button>

        <script>
            function toMain() {
                location.href = "${pageContext.request.contextPath}/account";
            }
        </script>

        <script>
            function reload() {
                setTimeout(function () {
                    window.location.reload();
                }, 1000);
            }
        </script>

        <script type="text/javascript">
            function loadXMLDoc() {
                var xmlhttp ;
                if (window.XMLHttpRequest)
                    xmlhttp= new XMLHttpRequest();
                else
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                xmlhttp.onreadystatechange = function() {
                    if (xmlhttp.readyState == 4) {
                        if (xmlhttp.status == 200) {
                            document.getElementById('message').innerHTML =xmlhttp.responseText;
                            document.getElementById('dischargeButton').disabled = true;
                        } else {
                            alert('error ' + xmlhttp.status);
                        }
                    }
                };

                xmlhttp.open("POST", "discharge");
                xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                xmlhttp.send();
            }
        </script>
    </jsp:body>
</t:_tag>
