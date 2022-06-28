<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Products Management Application</title>
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
            <a class="navbar-brand"> Products
                Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Products</a></li>
        </ul>
    </nav>
</header>

<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Coffee</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/newcoffee" class="btn btn-success">Add
                New Coffee</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Region</th>
                <th>Growth Height</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="coffee" items="${listCoffee}">

                <tr>
                    <td><c:out value="${coffee.region}" /></td>
                    <td><c:out value="${coffee.growthHeight}" /></td>
                    <td><a href="editcoffee?id=<c:out value='${coffee.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="deletecoffee?id=<c:out value='${coffee.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Tea</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/newtea" class="btn btn-success">Add
                New Tea</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Province</th>
                <th>Type</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="tea" items="${listTea}">

                <tr>
                    <td><c:out value="${tea.province}" /></td>
                    <td><c:out value="${tea.type}" /></td>
                    <td><a href="edittea?id=<c:out value='${tea.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="deletetea?id=<c:out value='${tea.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Chocolate</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/newchocolate" class="btn btn-success">Add
                New Chocolate</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Percent of Cocoa</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="chocolate" items="${listChocolate}">

                <tr>
                    <td><c:out value="${chocolate.percent}" /></td>
                    <td><c:out value="${chocolate.country}" /></td>
                    <td><a href="editchocolate?id=<c:out value='${chocolate.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="deletechocolate?id=<c:out value='${chocolate.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>

</body>
</html>