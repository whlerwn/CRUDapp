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
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${chocolate != null}">
            <form action="updatechocolate" method="post">
                </c:if>
                <c:if test="${chocolate == null}">
                <form action="insertchocolate" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${chocolate != null}">
                                Edit Chocolate
                            </c:if>
                            <c:if test="${chocolate == null}">
                                Add New Chocolate
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${chocolate != null}">
                        <input type="hidden" name="id" value="<c:out value='${chocolate.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Brand</label>
                        <input type="text" value="<c:out value='${chocolate.name}' />"
                                   class="form-control" name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Percent Of Cocoa</label>
                        <input type="number" value="<c:out value='${chocolate.percent}' />"
                               class="form-control" name="percent" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Country</label>
                        <input type="text" value="<c:out value='${chocolate.country}' />"
                               class="form-control" name="country">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>