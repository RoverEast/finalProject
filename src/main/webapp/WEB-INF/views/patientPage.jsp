<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 29.05.2017
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>

<t:_tag>
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col-lg-11">
                    <h3><fmt:message
                            key="welcom" bundle="${messages}"/> ${user.firstName} ${user.secondName}</h3>
                </div>
                <div class="col-lg-1 button">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <form>
                        <fmt:message
                        key="doctor" bundle="${messages}"/>: ${doctor.firstName} ${doctor.secondName}<br>
                        <fmt:message
                        key="nurse" bundle="${messages}"/>: ${nurse.firstName} ${nurse.secondName}
                        <br>
                        <fmt:message key="sick" bundle="${messages}"/>:
                        <c:forEach items="${sickList}" var="sickList">
                            ${sickList.name}<br>
                        </c:forEach>
                        <br>
                        <br>
                        <fmt:message key="mixture" bundle="${messages}"/>:
                        <c:forEach items="${mixturesList}" var="mixturesList">
                            ${mixturesList.name}<br>
                        </c:forEach>
                        <br>
                        <br>
                        <fmt:message key="operation" bundle="${messages}"/>:
                        <c:forEach items="${operationsList}" var="operationsList">
                            ${operationsList.name}<br>
                        </c:forEach>
                        <br>
                        <br>
                        <fmt:message key="procedure" bundle="${messages}"/>:
                        <c:forEach items="${proceduresList}" var="proceduresList">
                            ${proceduresList.name}<br>
                        </c:forEach>
                    </form>
                </div>
            </div>
        </div>
        <form action="logout" method="post">
            <button type="submit"><fmt:message key="logout" bundle="${messages}"/></button>
        </form>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
    </jsp:body>
</t:_tag>

