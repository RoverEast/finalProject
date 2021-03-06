<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <h3><fmt:message
                key="welcom" bundle="${messages}"/> ${user.firstName} ${user.secondName}</h3>
        <div class="container">

                    <form method="post" action="handler">
                        <c:forEach items="${patients}" var="patients">
                            <input required type="radio" name="patient"
                                   value="${patients.id}">  ${patients.firstName} ${patients.secondName}<br>
                        </c:forEach>
                        <c:if test="${fn:length(patients) eq 0}">
                            <fmt:message key="emptyList" bundle="${messages}"/>
                        </c:if>
                        <c:if test="${fn:length(patients) gt 0}">
                            <button id="sub" type="submit" value="Select" name="select"><fmt:message key="select"
                                                                                       bundle="${messages}"/></button>
                        </c:if>
                        <br>
                        <br>
                    </form>


                    <form action="logout" method="post">
                        <button type="submit"><fmt:message key="logout" bundle="${messages}"/></button>
                    </form>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
    </jsp:body>
</t:_tag>
