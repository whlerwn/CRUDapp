<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Coffee Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a class="navbar-brand"> Coffee
                Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Coffee</a></li>
        </ul>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/orders"
                   class="nav-link">Orders</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">Orders</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/order-form.jsp" class="btn btn-success">Add
                New Order</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Customer</th>
                <th>Address</th>
                <th>Amount, g</th>
                <th>Sort</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td><c:out value="${order.customer}" /></td>
                    <td><c:out value="${order.address}" /></td>
                    <td><c:out value="${order.sum}" /></td>
                    <td><c:out value="${order.sort}" /></td>
                    <td><c:out value="${order.country}" /></td>
                    <td><a href="deleteorder?id=<c:out value='${order.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>
</body>
</html>