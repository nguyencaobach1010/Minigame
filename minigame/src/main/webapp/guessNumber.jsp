<%@ page import="org.w3c.dom.ls.LSOutput" %>
<%@ page import="model.Player" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
    table, th, td {
        border:1px solid black;
    }
    table{
        width:50%;
        border-collapse: collapse;
    }
</style>
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<%!
    int number = 1;
%>
<div class="container">
    <div class="row mt-5">
        <div class="col-md-5 m-auto mt-5">
            <h3 class="text-center">ĐOÁN SỐ</h3>
            <h3 class="text-center">Đoán số ngẫu nhiên trong khoảng từ 1-1000</h3>

            <div class="p-4 border mt-4">
                <% String contextPath = request.getContextPath();%>
                <form action="<%=contextPath%>/random" method="post">
                    <div class="form-group">
                        <h6 style="color: red">${msg}</h6>
                        <label>Nhập số</label>
                        <input type="number" class="form-control" name="guessNumber">
                    </div>
                    <button type="submit" class="btn btn-primary">Lưu lại</button>
                </form>
            </div>
        </div>
    </div>
</div>
<table>
    <tr>
        <td>Xếp hạng</td>
        <td>Tên</td>
        <td>Số lần đoán</td>
    </tr>
    <c:if test="${players!=null}">
        <% number = 1;%>
        <c:forEach var="list" items="${players}">
            <tr>
                <td><%=number%>
                </td>
                <td>Player <%=number%>
                </td>
                <td>${list.guessCount}</td>
            </tr>
            <%
                number++;
            %>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
