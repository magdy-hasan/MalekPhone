<%-- 
    Document   : index.jsp
    Created on : Oct 6, 2016, 1:27:20 PM
    Author     : Lenovo
--%>


<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<head>
    <title>Free Home Shoppe Website Template | Preview :: w3layouts</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script> 
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
    <link href="css/easy-responsive-tabs.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="css/global.css">
    <script src="js/slides.min.jquery.js"></script>
</head>
<body>
    <div class="wrap">
        <div class="header">
            <div class="headertop_desc">
                <div class="call">
                    <p><span>Need help?</span> call us <span class="number">1-22-3456789</span></span></p>
                </div>
                <div class="clear"></div>
            </div>
            <div class="header_top">
                <div class="logo">
                    <a href="index.jsp"><img src="images/logo/logo.png" alt="" /></a>
                </div>
                <div class="clear"></div>
            </div>
            <div class="header_bottom">
                <div class="menu">
                    <ul>
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="about.html">About</a></li>
                        <li><a href="delivery.html">Delivery</a></li>
                        <li><a href="news.html">News</a></li>
                        <li><a href="contact.html">Contact</a></li>
                        <div class="clear"></div>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>	     	
        </div>
        <div class="main">
            <div class="content">
                <div class="content_top">
                    <div class="heading">
                        <h3>New Products</h3>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="section group">
                    <div class="cont-desc span_1_of_2">

                        <div class="section group">
                            <c:forEach var="ph" items="${allPH}">
                                <c:if test="${(empty param.category_type) || (param.category_type == ph.value.category_id) }">
                                    <div class="grid_1_of_4 images_1_of_4">
                                        <a href="${pageContext.request.contextPath}/preview.jsp?product_id=${ph.value.id}"><img src="images/${ph.value.img_path}" alt="" /></a>
                                        <h2>${ph.value.name}</h2>
                                        <div class="price-details">
                                            <div class="price-number">
                                                <p><span class="rupees">${ph.value.cost} جنية</span></p>
                                            </div>
                                            <div class="add-cart">								
                                                <h4><a href="preview.html">view</a></h4>
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                    </div>	
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="rightsidebar span_3_of_1">
                        <h2>CATEGORIES</h2>
                        <ul>
                            <c:forEach var="cate" items="${allCA}">
                                <li><a href="${pageContext.request.contextPath}/index.jsp?category_type=${cate.value.id}">${cate.value.name}</a></li>
                                </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="wrap">	
            <div class="section group">
                <div class="col_1_of_4 span_1_of_4">
                    <h4>Information</h4>
                    <ul>
                        <li><a href="about.html">About Us</a></li>
                        <li><a href="contact.html">Customer Service</a></li>
                        <li><a href="#">Advanced Search</a></li>
                        <li><a href="delivery.html">Orders and Returns</a></li>
                        <li><a href="contact.html">Contact Us</a></li>
                    </ul>
                </div>
                <div class="col_1_of_4 span_1_of_4">
                    <h4>Why buy from us</h4>
                    <ul>
                        <li><a href="about.html">About Us</a></li>
                        <li><a href="contact.html">Customer Service</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="contact.html">Site Map</a></li>
                        <li><a href="#">Search Terms</a></li>
                    </ul>
                </div>
                <div class="col_1_of_4 span_1_of_4">
                    <h4>My account</h4>
                    <ul>
                        <li><a href="contact.html">Sign In</a></li>
                        <li><a href="index.html">View Cart</a></li>
                        <li><a href="#">My Wishlist</a></li>
                        <li><a href="#">Track My Order</a></li>
                        <li><a href="contact.html">Help</a></li>
                    </ul>
                </div>
                <div class="col_1_of_4 span_1_of_4">
                    <h4>Contact</h4>
                    <ul>
                        <li><span>+91-123-456789</span></li>
                        <li><span>+00-123-000000</span></li>
                    </ul>
                    <div class="social-icons">
                        <h4>Follow Us</h4>
                        <ul>
                            <li><a href="#" target="_blank"><img src="images/facebook.png" alt="" /></a></li>
                            <li><a href="#" target="_blank"><img src="images/twitter.png" alt="" /></a></li>
                            <li><a href="#" target="_blank"><img src="images/skype.png" alt="" /> </a></li>
                            <li><a href="#" target="_blank"> <img src="images/dribbble.png" alt="" /></a></li>
                            <li><a href="#" target="_blank"> <img src="images/linkedin.png" alt="" /></a></li>
                            <div class="clear"></div>
                        </ul>
                    </div>
                </div>
            </div>			
        </div>
        <div class="copy_right">
            <p>Company Name © All rights Reseverd | Design by  <a href="http://w3layouts.com">W3Layouts</a> </p>
        </div>
    </div>
    <script type="text/javascript">
        $(document).ready(function () {
            $().UItoTop({easingType: 'easeOutQuart'});

        });
    </script>
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

