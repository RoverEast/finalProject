<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<t:_tag title="Error">
    <jsp:body>
        <fmt:message key="pageNotFound" bundle="${messages}"/>
    </jsp:body>
</t:_tag>