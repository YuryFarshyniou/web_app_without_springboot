<%--
  Created by IntelliJ IDEA.
  User: USER1
  Date: 4/26/2021
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change current product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-8">
            <form action="change" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Phone name to change</label>
                    <input name="oldName" type="text" class="form-control" id="exampleInputEmail"
                           aria-describedby="emailHelp" placeholder="Phone name to change">
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">New Name</label>
                    <input name="name" type="text" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp" placeholder="New Name">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">New Price</label>
                    <input name="price" type="text" class="form-control" id="exampleInputPassword1" placeholder="New Price">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">New Processor</label>
                    <input name="processor" type="text" class="form-control" id="exampleInput" placeholder="New Processor">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>

</body>
</html>
