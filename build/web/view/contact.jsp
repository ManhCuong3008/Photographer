<%-- 
    Document   : home
    Created on : Jun 10, 2021, 11:01:49 PM
    Author     : NguyenManhCuong
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:url value="/view/css/style.css"></c:url>">
            <title>Photographer</title>
        </head>
        <body>
            <div id="wapper">
            <%@include file="components/header.jsp"%>
            <div id="content">
                <div class="container">
                    <div id="left">
                        <div class="left-home">
                           <h4>Contact</h4>
                           <h3 class="title-info">PHOTOGRAPHER</h3>
                            <p class="info-text ">Address: ${contact.address}</p>
                            <p class="info-text ">City: ${contact.city}</p>
                            <p class="info-text ">Country: ${contact.country}</p>
                            <p class="info-text ">Tel: ${contact.telephone}</p>
                            <p class="info-text ">Email:<a href="">${contact.email}</a></p> 
                        </div>
                        <div class="category">
                            ${contact.map}
                        </div>
                    </div>
                    <%@include file="components/right.jsp" %>
                </div>
            </div>
            <%@include file="components/footer.jsp" %>
        </div>
         <script src="view/js/images.js"></script>
    </body>
</html>
