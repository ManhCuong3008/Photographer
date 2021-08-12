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
                            <img class="home-image"  src="<c:url value="/view/images/${contact.imageMain}"></c:url>" alt="homeImage">
                            <i>${contact.contentMain}</i>
                        </div>
                        <div class="category">
                            <c:forEach var="listModel" items="${list}">
                                <div class="category-gallery">
                                    <img  src="<c:url value="/view/images/${listModel.url}"></c:url>" alt="">
                                    <h4><a class="title-gallery" href="gallery?id=${listModel.id}">${listModel.title}</a></h4>
                                    <p class="line-height">${listModel.description}</p>
                                </div>
                            </c:forEach>
                        </div>
                         <center>   
                            <c:forEach begin="1" end="${totalPage}" var="i">
                                <div class="paging" >
                                    <c:if test="${index==i}">
                                        <a style="background: cadetblue;" href="home?index=${i}">${i}</a>
                                    </c:if>
                                    <c:if test="${index!=i}">
                                        <a href="home?index=${i}">${i}</a>
                                    </c:if>
                                    
                                </div>
                            </c:forEach>
                        </center>
                        <div class="about-me">
                            <h3>About me</h3>
                            <p class="line-height">${contact.about}</p>
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
