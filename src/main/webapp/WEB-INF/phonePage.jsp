<%--
  Created by IntelliJ IDEA.
  User: USER1
  Date: 5/15/2021
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PhonePage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

</head>
<body>


<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-8">
            <td class="image"><img src=${phone.img} width="600"
                                   height="500" alt="Image"/></td>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Name</td>
                    <td>${phone.name}</td>

                </tr>
                <tr>
                    <td>Processor</td>
                    <td>${phone.processor}</td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td>${phone.price}</td>

                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
