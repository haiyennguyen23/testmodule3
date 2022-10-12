<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Student Management Application</title>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="students?action=students">List All Students</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Student
                </h2>
            </caption>
            <c:if test="${student != null}">
                <input type="hidden" name="id" value="<c:out value='${student.id}' />"/>
            </c:if>
            <tr>
                <th>Student Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${student.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student Date Of Birth:</th>
                <td>
                    <input type="date" name="dateOfBirth" size="45"
                           value="<c:out value='${student.dateOfBirth}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${student.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student Phone Number:</th>
                <td>
                    <input type="number" name="phoneNumber" size="45"
                           value="<c:out value='${student.phoneNumber}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${user.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Classroom:</th>
                <td>
                    <input type="text" name="classroom" size="15"
                           value="<c:out value='${student.country}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
