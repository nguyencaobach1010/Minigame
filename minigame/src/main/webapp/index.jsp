<%@ page import="org.w3c.dom.ls.LSOutput" %>
<%@ page import="model.Player" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<header>
    <h1>Guess My Number!</h1>
</header>
<% String contextPath = request.getContextPath(); %>
<form action="<%=contextPath%>/random">
    <button type="submit" class="btn btn-primary">Bắt đầu chơi</button>
</form>
</main>
<script src="script.js"></script>
</body>
</html>
