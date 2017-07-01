<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_tag title="Login">
    <jsp:body>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 login checkTable">
                <form action="${pageContext.request.contextPath}/login" method="post" class="signin">
                    <table class="textData">
                        <tr>
                            <td >
                                <label for="exampleInputEmail1"><fmt:message key="emailAdress"
                                                                             bundle="${messages}"/></label>
                            </td>
                            <td>
                                <input id="exampleInputEmail1" type="text" name="login">
                            </td>
                        </tr>

                        <tr>
                            <td >
                                <label for="exampleInputPassword1"><fmt:message key="password1"
                                                                                bundle="${messages}"/></label>
                            </td>
                            <td>
                                <input id="exampleInputPassword1" type="password" name="password">
                            </td>
                        </tr>
                    </table>
                    <button type="submit"><fmt:message key="signIn" bundle="${messages}"/></button>
                </form>
                <button onclick="a()"><fmt:message key="registers" bundle="${messages}"/></button>
            </div>
        </div>

        <script type="text/javascript">
            function a() {
                location.href = "${pageContext.request.contextPath}/registration";
            }</script>

    </jsp:body>

</t:_tag>


