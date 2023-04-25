<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 4/25/2023
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
