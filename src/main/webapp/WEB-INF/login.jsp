<%--
  Created by IntelliJ IDEA.
  User: USER1
  Date: 4/26/2021
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <div class="fadeIn first">
            <img src="https://www.reliancedigital.in/medias/OnePlus-9-Series-CLP-Banner-23-03-2021-Mobile.jpg?context=bWFzdGVyfGltYWdlc3w0MTkyNnxpbWFnZS9qcGVnfGltYWdlcy9oZTUvaDQxLzk1MDA3OTQzMjI5NzQuanBnfDhjZTlmMTQ1OGIzY2U3YWZhNDY3MzNmY2E2ZDM2M2M1OWU1NjhhYjgyM2NiZTcwNzBiYjk5MDU3NmU2ZTk3MzQ"
                 id="icon" alt="User Icon" />
        </div>

        <!-- Login Form -->
        <form action="login" method="post">
            <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
            <input type="password" id="password" class="fadeIn third" name="pass" placeholder="password">
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>

    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
</body>
</html>
