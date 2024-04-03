<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="/writingProject/css/navbars-offcanvas.css" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EVERYDAY Writing</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* 추가적인 스타일링이 필요한 경우 여기에 작성하세요 */
        #fairy-tale-content {
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">EveryDay Writing</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbarLight"
                aria-controls="offcanvasNavbarLight" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbarLight"
             aria-labelledby="offcanvasNavbarLightLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasNavbarLightLabel">Offcanvas</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="/userList">UserList</a>
                    </li>
                    <li class="nav-item">
                        <c:choose>
                            <c:when test="${empty sessionScope.user}">
                                <a class="nav-link" href="/login">Login</a>
                            </c:when>
                            <c:otherwise>
                                <a class="nav-link" href="/logout">Logout</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            Dropdown
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/recordList">Record</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <%-- 사용자 이름 표시 --%>
                    <li class="nav-item">
                        <c:choose>
                            <c:when test="${not empty sessionScope.user}">
                                Welcome, ${sessionScope.user.name}
                                <c:if test="${not empty sessionScope.user.userNum}">
                                    Welcome, ${sessionScope.user.userNum}
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                <a class="nav-link" href="/login">Login</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </ul>
                <form class="d-flex mt-3" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </div>
</nav>

<div class="container">
    <div class="text-center mt-5">
        <h1>Just Do It EveryDay !</h1>
        <div class="mb-3" style="text-align: left;">
            <h3>
                <%-- 랜덤하게 선택된 동화의 제목 출력 --%>
                <c:if test="${not empty randomFairyTale}">
                    ${randomFairyTale.title}
                </c:if>
            </h3>
        </div>
        <div id="fairy-tale-content" class="mb-3">
            <%-- 랜덤하게 선택된 동화의 내용 출력 --%>
            <c:if test="${not empty randomFairyTale}">
                <p>${randomFairyTale.content}</p>
            </c:if>
        </div>

        <div class="mb-5">
            <form action="/insertRecord" method="post">
                <div class="input-group">
                    <input type="text" class="form-control" name="secondTextbox" placeholder="두 번째 텍스트 박스">
                    <input type="hidden" name="randomFairyTaleTitle" value="${randomFairyTale.title}">
                    <c:choose>
                        <c:when test="${not empty sessionScope.user}">
                            <c:if test="${not empty sessionScope.user.userNum}">
                                <input type="hidden" name="userNum" value="${sessionScope.user.userNum}">
                            </c:if>
                        </c:when>
                    </c:choose>
                    <button type="submit" class="btn btn-success">데이터 삽입</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
