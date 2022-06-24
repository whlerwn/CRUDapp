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
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="insertorder" method="post">
                <caption><h2>Add New Order</h2></caption>
                <input type="hidden" name="id" value="<c:out value='${order.id}' />" />

                    <fieldset class="form-group">
                        <label>Customer</label>
                        <input type="text" value="<c:out value='${order.customer}' />"
                               class="form-control" name="customer" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Address</label>
                        <input type="text" value="<c:out value='${order.address}' />"
                               class="form-control" name="address">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Amount in grams</label>
                        <input type="number" value="<c:out value='${order.sum}' />"
                               class="form-control" name="sum">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Product number</label>
                        <input type="number" value="<c:out value='${order.product_id}' />"
                               class="form-control" name="product_id">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>