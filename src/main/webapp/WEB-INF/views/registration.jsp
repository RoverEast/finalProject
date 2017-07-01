<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_tag title="Registration">
    <jsp:body>
        <form method="post" action="${pageContext.request.contextPath}/registration">
            <h1><fmt:message
                    key="registration" bundle="${messages}"/></h1>
            <table class="textDataRegistr">
                <tr>
                    <td>
                        <label for="login"><fmt:message key="email" bundle="${messages}"/></label>
                    </td>
                    <td>
                        <input id="login" type="text" name="username" required>
                    </td>
                </tr>
                <tr>
                    <td>
                    <label for="password"><fmt:message key="password1" bundle="${messages}"/></label>
                    </td>
                    <td>
                    <input id="password" type="password" name="password" required>
                    </td>
                </tr>

                <tr>
                    <td>
                    <label for="firstName"><fmt:message key="firstName" bundle="${messages}"/></label>
                    </td>
                    <td>
                    <input id="firstName" type="text" name="firstName" required>
                    </td>
                </tr>
                <tr>
                    <td>
                    <label for="secondName"><fmt:message key="secondName" bundle="${messages}"/></label>
                    </td>
                    <td>
                    <input id="secondName" type="text" name="secondName" required>
                    </td>
                </tr>
                <tr>
                    <td>
                    <label for="patronimyc"><fmt:message key="patronymic" bundle="${messages}"/></label>
                    </td>
                    <td>
                    <input id="patronimyc" type="text" name="middleName">
                    </td>
                </tr>


                <tr>
                    <td>
                    <label><fmt:message key="position" bundle="${messages}"/></label>
                    </td>
                    <td>
                    <input type="radio" name="position" value="DOC" required>
                    <fmt:message key="doctor" bundle="${messages}"/>
                    <br>
                    <input type="radio" name="position" value="NURSE" required>
                    <fmt:message key="nurse" bundle="${messages}"/>
                    <br>
                    <input type="radio" name="position" value="PATIENT" required>
                    <fmt:message key="patient" bundle="${messages}"/>
                    </td>
                </tr>


                <tr>
                    <td>
                    <label><fmt:message key="birthDate" bundle="${messages}"/></label>
                    </td>
                    <td>
                    <input type="date" name="birthDate" required placeholder="">
                    </td>
                </tr>
            </table>
            <button type="submit" value="Submit" ><fmt:message key="submit" bundle="${messages}"/></button>


        </form>
        <button onclick="toMain()"><fmt:message key="back" bundle="${messages}"/></button>

        <script>
            function toMain() {
                location.href = "${pageContext.request.contextPath}/login";
            }
        </script>
    </jsp:body>
</t:_tag>