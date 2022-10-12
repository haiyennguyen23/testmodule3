<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Student Management Application</title>
</head>
<body>
<center>
    <h1>Students Management</h1>
    <h2>
        <a href="/students?action=create">Add New Student</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Students</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date Of Birth</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Classroom</th>
        </tr>
        <c:forEach var="student" items="${listStudent}">
            <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.dateOfBirth}"/></td>
                <td><c:out value="${student.address}"/></td>
                <td><c:out value="${student.phoneNumber}"/></td>
                <td><c:out value="${student.email}"/></td>
                <td><c:out value="${student.classroom}"/></td>
                <td>
                    <a href="/students?action=edit&id=${student.id}">Edit</a>
                    <a href="/students?action=delete&id=${student.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
