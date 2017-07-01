<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 18.06.2017
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<%@attribute name="title" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <title>${title}</title>

    <meta charset="utf-8">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css"/>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/style.css" rel="stylesheet">

</head>
<body>

<!--
<img src="${pageContext.request.contextPath}/resources/bootstrap/css/images/header.png" class="head">-->
<nav class="navbar navbar-default">
    <div class="container">
        <!-- Note that the .navbar-collapse and .collapse classes have been removed from the #navbar -->
        <div class="row">
            <div id="navbar">
                <div class="col-lg-4 col-md-4 col-sm-2 col-xs-2 col-lg-offset-5 col-md-offset-5 col-sm-offset-2 col-xs-offset-2 login">
                    <ul class="nav navbar-nav">
                        <li>
                            <form method="post" action="${pageContext.request.contextPath}/config/language">
                                <button class="btn btn-default btn-block" type="submit" formmethod="post" name="local"
                                        value="rus">Русский
                                </button>
                            </form>
                        </li>
                        <li>
                            <form method="post" action="${pageContext.request.contextPath}/config/language">
                                <button class="btn btn-default btn-block" type="submit" formmethod="post" name="local"
                                        value="en">English
                                </button>
                            </form>
                        </li>
                        <li>
                            <form action="logout" method="post">
                                <button class="btn btn-default btn-block" type="submit"><fmt:message key="logout" bundle="${messages}"/></button>

                            </form>
                        </li>
                    </ul>
                </div>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11">
            <jsp:doBody/>
        </div>
        <div  class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
            <img id="time" src="${pageContext.request.contextPath}/resources/bootstrap/css/images/<fmt:message key="time"
                                                                            bundle="${messages}"/>">
        </div>
    </div>
</div>

<div class="footer">
    <fmt:message key="final" bundle="${messages}"/>
</div>
</body>

<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>

</html>
