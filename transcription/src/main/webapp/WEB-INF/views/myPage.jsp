<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* 추가적인 스타일링이 필요한 경우 여기에 작성하세요 */
        .container {
            padding: 20px;
        }
        .edit-button-container {
            text-align: center; /* 수정 버튼을 가운데 정렬 */
            margin-top: 20px; /* 수정 버튼과 카드 사이의 간격 조절 */
        }
    </style>
</head>
<body>

<div class="container">
    <h1 class="text-center"><a href="/">My Page</a></h1>
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">User Information</h5>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><strong>User Number:</strong> ${userNum}</li>
                        <li class="list-group-item"><strong>ID:</strong> ${id}</li>
                        <li class="list-group-item"><strong>Name:</strong> ${name}</li>
                        <li class="list-group-item"><strong>Email:</strong> ${email}</li>
                    </ul>
                </div>
            </div>
            <div class="edit-button-container">
                <button onclick="location.href='/myPageUpdate'" class="btn btn-primary">수정</button>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
