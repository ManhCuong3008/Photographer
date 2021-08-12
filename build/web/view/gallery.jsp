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
                            <c:if test="${not empty viewImageModel}">
                                <div class="view-detail">
                                    <span class="back-to-album"><a href="gallery?id=${modelGallery.id}"> ⬅ Back to album</a></span>
                                    <c:if test="${not empty idBefore}">
                                        <span><a style="padding: 0px 10px;" href="gallery?id=${modelGallery.id}&view=${idBefore}"> ◀ </a></span>
                                    </c:if>
                                    <c:if test="${not empty idAfter}">
                                        <span><a style="padding: 0px 10px;" href="gallery?id=${modelGallery.id}&view=${idAfter}"> ▶ </a></span>
                                    </c:if>
                                </div>
                                <img id="myImg" src="view/images/${viewImageModel.url}" alt="Images">                            
                            </c:if>
                            <c:if test="${empty viewImageModel}">
                                <h4 class="">${modelGallery.name}</h4>
                                <div class="slides">
                                    <c:set var = "i" scope = "session" value = "0"/>
                                    <c:forEach var="item" items="${modelGallery.listImages}">
                                        <c:if test="${i == 0}">
                                            <a href="gallery?id=1&view=${item.id}">
                                                <img class="slide active" src="view/images/${item.url}" alt="homeImage">
                                            </a>
                                        </c:if>
                                        <c:if test="${i != 0}">
                                            <a href="gallery?id=1&view=${item.id}">
                                                <img class="slide" src="view/images/${item.url}" alt="homeImage">
                                            </a>
                                        </c:if>
                                        <c:set var = "i" scope = "session" value = "${i+1}"/>
                                    </c:forEach>
                                     <div class="play">
                                        <button class="controls" id="pause">Pause</button>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                        <c:if test="${empty viewImageModel}">
                            <div class="category">
                                <c:forEach var="item" items="${modelPaging}">
                                    <div class="thumnail">
                                        <a href="<c:url value="/gallery?id=${idGallerry}&view=${item.id}"></c:url>">
                                            <img  src="view/images/${item.url}"alt="">
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                            <center> 
                                <c:forEach begin="1" end="${totalPage}" var="i">
                                    <div class="paging" >
                                        <c:if test="${index==i}">
                                             <a style="background: cadetblue;" href="<c:url value="gallery?id=${idGallerry}&index=${i}"></c:url>">${i}</a>
                                        </c:if>
                                        <c:if test="${index!=i}">
                                             <a  href="<c:url value="gallery?id=${idGallerry}&index=${i}"></c:url>">${i}</a>
                                        </c:if>
                                    </div>
                                </c:forEach>
                            </center>
                        </c:if>
                    </div>
                    <%@include file="components/right.jsp" %>
                </div>
            </div>
            <%@include file="components/footer.jsp" %>
        </div>
        <script src="view/js/images.js"></script>
        <c:if test="${empty viewImageModel}">
            <script src="view/js/slide.js"></script>
        </c:if>
    </body>
</html>
