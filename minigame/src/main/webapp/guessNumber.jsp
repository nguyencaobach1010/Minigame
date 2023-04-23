<%@ page import="org.w3c.dom.ls.LSOutput" %>
<%@ page import="model.Player" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row mt-5">
        <div class="col-md-5 m-auto mt-5">
            <h3 class="text-center">ĐOÁN SỐ</h3>
            <div class="p-4 border mt-4">
                <% String contextPath = request.getContextPath();%>
                <form action="<%=contextPath%>/random" method="post">
                    <div class="form-group">
                        <label>Người chơi</label>
                        <input type="text" class="form-control" name="name">
                    </div>
                    <div class="form-group">
                        <label>Nhập số</label>
                        <input type="number" class="form-control" name="guessNumber">
                    </div>
                    <button type="submit" class="btn btn-primary">Lưu lại</button>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="alert"><p>${message}</p></div>
<div class="mt-4">
    <table class="table table-bordered">
        <thead>
        <th scope="col">Tên người chơi</th>
        <th scope="col">Số lần đoán</th>
        <th scope="col">Số đoán đúng</th>
        </thead>
        <tbody>
        <c:forEach items="${listPlayer}" var="player">
            <tr>
                <td>${player.name}</td>
                <td>${player.guessNumber}</td>
                <td>${player.numOfGuess}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
