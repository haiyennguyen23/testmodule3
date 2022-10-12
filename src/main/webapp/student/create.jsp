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
                <h2>Add New Student</h2>
            </caption>
            <tr>
                <th>Student ID:</th>
                <td>
                    <input type="number" name="id" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Student Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Student Date Of Birth:</th>
                <td>
                    <input type="date" name="dateofBirth" id="dateOfBirth" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Student Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Student Phone Number:</th>
                <td>
                    <input type="number" name="phoneNumber" id="phoneNumber" size="45"/>
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Classroom:</th>
                <td>
                    <input type="text" name="classroom" id="classroom" size="15"/>
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