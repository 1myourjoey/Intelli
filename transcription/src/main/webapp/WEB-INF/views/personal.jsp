<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Record List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1><a href="/">Record List</a></h1>
<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>StoryId</th>
        <th>Content</th>
        <th>Status</th>
        <th>UserNum</th>
        <th>Time</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${personalRecords}" var="record">
        <tr>
            <td>${record.title}</td>
            <td>${record.storyId}</td>
            <td>${record.content}</td>
            <td>${record.status}</td>
            <td>${record.userNum}</td>
            <td>${record.time}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>