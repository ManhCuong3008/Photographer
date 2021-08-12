<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
    <div id="header-nav">
        <div class="container">
            <ul class="nav-link">
                <c:if test="${activeHome==true}">
                    <li><a style="font-weight: bold;" href="home">My front page</a></li>
                    </c:if>
                    <c:if test="${activeHome!=true}">
                    <li><a href="home">My front page</a></li>
                    </c:if>
                    <c:if test="${galleryHeader!=null}">
                        <c:forEach var="item" items="${galleryHeader}">
                            <c:if test="${id==item.id}">
                            <li><a style="font-weight: bold;" href="gallery?id=${item.id}">${item.name}</a></li>
                            </c:if>
                            <c:if test="${id!=item.id}">
                            <li><a href="gallery?id=${item.id}">${item.name}</a></li>
                            </c:if>
                        </c:forEach>
                    </c:if> 
                    <c:if test="${activeContact==true}">
                    <li><a style="font-weight: bold;" href="<c:url value="/contact"></c:url>">Contact</a></li>
                    </c:if>
                    <c:if test="${activeContact!=true}">
                    <li><a href="<c:url value="/contact"></c:url>">Contact</a></li>
                    </c:if>
            </ul>
        </div>
    </div>
    <div class="header-nav-dropdown">
        <button id="btn-menu" onclick="dropDown()">Menu</button>
        <ul class="nav-link">
            <li><a href="home">My front page</a></li>
                <c:forEach var="item" items="${galleryHeader}">
                <li><a href="gallery?id=${item.id}">${item.name}</a></li>
                </c:forEach>
            <li><a href="<c:url value="/contact"></c:url>">Contact</a></li>
            </ul>
        </div>
        <div id="header-title">
            <div class="container">
                <a class="logo" href="home"><img src="<c:url value="/view/images/logo.png"></c:url>" alt="Logo"></a>
            <div class="title">
                <a href="home">PHOTOGRAPHER</a>
            </div>
            <div class="subtitle">Welcome to this website</div>
        </div>
    </div>
</div>