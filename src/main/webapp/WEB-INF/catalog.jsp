<%--
  Created by IntelliJ IDEA.
  User: USER1
  Date: 4/26/2021
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>PhonesCatalog</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href='https://fonts.googleapis.com/css?family=Lobster'>
    <link rel="stylesheet" href="css/catalog.css">

</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-xxl">
            <a class="navbar-brand" href="home">MobileStore</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="admin">admin page</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login">login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="catalog">catalog</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Action
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="addPhone">Add new phone</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="d-flex" action="phonePage">
                    <input class="form-control me-2" type="search" placeholder="Search phone" aria-label="Search"
                           name="name">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-8">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th></th>
                    <th>Price</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>

                </thead>
                <tbody>
                <c:forEach var="phone" items="${phones}" varStatus="status">
                    <tr>
                        <td class="name_column">${phone.name}</td>
                        <td class="image"><img src=${phone.img} width="400"
                                               height="300" alt="Image"/></td>
                        <td class="price_column">${phone.price}</td>

                        <td>
                            <form action="remove" method="post" name="removePhone">
                                <input type="hidden" value="${phone.id}" name="id">
                                <input class="btn btn-dark" type="submit" name="remove" value="Remove"/>
                            </form>
                        </td>
                        <td>
                            <form action="phonePage" method="get" name="moreInfo">
                                <input type="hidden" value="${phone.name}" name="name">
                                <input class="btn btn-dark" type="submit" name="info" value="More info"/>
                            </form>
                        </td>
                        <td>
                            <form action="change" method="get" name="update">
                                <input type="hidden" value="${phone.id}" name="id">
                                <input class="btn btn-dark" type="submit" name="info" value="Update"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
            crossorigin="anonymous"></script>

</div>
</body>
</html>

