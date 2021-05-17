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
    <title>HomePage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="css/home.css"/>
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
                        <a class="nav-link" href="admin">Admin page</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="catalog">Catalog</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Action
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="change">Update Phone</a></li>
                            <li><a class="dropdown-item" href="addPhone">Add new phone</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search phone" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<section>
    <div class="container-xxl">
        <div class="row align-items-center">
            <div class="col-7">
                <h1>Welcome to our shop</h1>
            </div>
            <div class="col-5">
                <img class="w-100"
                     src="https://images.ctfassets.net/16nm6vz43ids/4vD81JGt6p6lZlqw5egaSk/04959d81b2cb4ec990e13756cea56e8d/Find-lock-or-erase-your-Android-phone.jpeg"
                     alt="Phones">
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container-xxl">
        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="row justify-content-between">
                        <div class="col">
                            <div class="card w-100">
                                <img src="https://i.expansys.net/img/b/330002/samsung-galaxy-s21-ultra-5g-dual-sim-sm-g9980.jpg"
                                     class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Samsung Galaxy s21 Ultra</h5>
                                    <p class="card-text">Exunos 2100, 108 Mp, Diagonal 6.8 </p>
                                    <form action="phonePage" method="get" name="moreInfo">
                                        <input type="hidden" value="more_info" name="command">
                                        <input type="hidden" value="Samsung Galaxy s21 Ultra" name="name">
                                        <input class="btn btn-primary" type="submit" name="remove" value="More Info"/>
                                    </form>

                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card w-100">
                                <img src="https://i.gadgets360cdn.com/products/large/mi-11-ultra-db-800x800-1617265287.jpg"
                                     class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Xiaomi Mi 11 Ultra</h5>
                                    <p class="card-text">Snapdragon 888, 5000mAh</p>
                                    <form action="phonePage" method="get" name="moreInfo">
                                        <input type="hidden" value="more_info" name="command">
                                        <input type="hidden" value="Xiaomi Mi 11 Ultra" name="name">
                                        <input class="btn btn-primary" type="submit" name="remove" value="More Info"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card w-100">
                                <img src="https://cdn.alloallo.media/catalog/product/samsung/galaxy-s/galaxy-s20-ultra/galaxy-s20-ultra-cosmic-gray.jpg"
                                     class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Samsung Galaxy s20 Ultra</h5>
                                    <p class="card-text">Exynos 990, RAM 12 gb</p>
                                    <form action="phonePage" method="get" name="moreInfo">
                                        <input type="hidden" value="more_info" name="command">
                                        <input type="hidden" value="Samsung Galaxy s20 Ultra" name="name">
                                        <input class="btn btn-primary" type="submit" name="remove" value="More Info"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card w-100">
                                <img src="https://www.powerplanetonline.com/cdnassets/xiaomi_mi_11_lite_05_rosa_ad_l.jpg"
                                     class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Xiaomi Mi 11 lite</h5>
                                    <p class="card-text">Snapdragon 732G, RAM 6Gb</p>
                                    <form action="phonePage" method="get" name="moreInfo">
                                        <input type="hidden" value="more_info" name="command">
                                        <input type="hidden" value="Xiaomi Mi 11 lite" name="name">
                                        <input class="btn btn-primary" type="submit" name="remove" value="More Info"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="row justify-content-between">
                        <div class="col">
                            <div class="card w-100">
                                <img src="https://cdn.alzashop.com/ImgW.ashx?fd=f16&cd=REAM018b2"
                                     class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Realme 8 Pro</h5>
                                    <p class="card-text">Snapdragon 720G, RAM 8Gb</p>
                                    <form action="phonePage" method="get" name="moreInfo">
                                        <input type="hidden" value="more_info" name="command">
                                        <input type="hidden" value="Realme 8 Pro" name="name">
                                        <input class="btn btn-primary" type="submit" name="remove" value="More Info"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card w-100">
                                <img src="https://img.router-switch.com/media/customoptions/129/2/4/iphone-12-pro-max-blue.jpg"
                                     class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Iphone 12 Pro Max</h5>
                                    <p class="card-text">Apple A14 Bionic.</p>
                                    <form action="phonePage" method="get" name="moreInfo">
                                        <input type="hidden" value="more_info" name="command">
                                        <input type="hidden" value="Iphone 12 Pro Max" name="name">
                                        <input class="btn btn-primary" type="submit" name="remove" value="More Info"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card w-100">
                                <img src="https://www.gizmochina.com/wp-content/uploads/2021/03/Xiaomi-Poco-X3-Pro.jpg"
                                     class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Poco X3 Pro</h5>
                                    <p class="card-text">Snapdragon 860.</p>
                                    <form action="phonePage" method="get" name="moreInfo">
                                        <input type="hidden" value="more_info" name="command">
                                        <input type="hidden" value="Poco X3 Pro" name="name">
                                        <input class="btn btn-primary" type="submit" name="remove" value="More Info"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card w-100">
                                <img src="https://www.giztop.com/media/catalog/product/cache/dc206057cdd42d7e34b9d36e347785ca/x/i/xiaomi_mi_10_ultra_silver_4.jpg"
                                     class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Xiaomi Mi 10 Ultra</h5>
                                    <p class="card-text">Snapdragon 865.</p>
                                    <form action="phonePage" method="get" name="moreInfo">
                                        <input type="hidden" value="more_info" name="command">
                                        <input type="hidden" value="Xiaomi Mi 10 Ultra" name="name">
                                        <input class="btn btn-primary" type="submit" name="info" value="More Info"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>

        </div>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
</body>
</html>
