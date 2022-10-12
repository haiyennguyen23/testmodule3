package com.example.practiceexam.dao;

import com.example.practiceexam.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/testmodule3?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private static final String INSERT_STUDENTS_SQL = "INSERT INTO students(id, name, dateOfBirth, address, phoneNumber, email, classroom) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STUDENT_BY_ID = "select id, name, dateOfBirth, address, phoneNumber, email, classroom from students where id =?";
    private static final String SELECT_ALL_STUDENTS = "select * from students";
    private static final String DELETE_STUDENTS_SQL = "delete from students where id = ?;";
    private static final String UPDATE_STUDENTS_SQL = "update students set name= ?, dateOfBirth= ?, address= ?, phoneNumber= ?, email= ?, classroom= ? where id = ?;";

    public StudentDAO() {
    }
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertStudent(Student students) throws SQLException {
        System.out.println(INSERT_STUDENTS_SQL);
        try(Connection connection= getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_STUDENTS_SQL)){
            preparedStatement.setString(1,students.getName());
            preparedStatement.setString(2,students.getDateOfBirth());
            preparedStatement.setString(3,students.getAddress());
            preparedStatement.setString(4,students.getPhoneNumber());
            preparedStatement.setString(5,students.getEmail());
            preparedStatement.setString(6,students.getClassroom());

        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public Student selectStudent(int id) {
        Student student = null;
        try(Connection connection= getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_STUDENT_BY_ID)){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String name =resultSet.getString("name");
                String dateOfBirth=resultSet.getString("dateOfBirth");
                String address=resultSet.getString("address");
                String phoneNumber=resultSet.getString("phoneNumber");
                String email=resultSet.getString("email");
                String classroom=resultSet.getString("classroom");
                student=new Student(id,name,dateOfBirth,address,phoneNumber,email,classroom);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> students= new ArrayList<>();
        try(Connection connection= getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_STUDENTS)){
            System.out.println(preparedStatement);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name =resultSet.getString("name");
                String dateOfBirth=resultSet.getString("dateOfBirth");
                String address=resultSet.getString("address");
                String phoneNumber=resultSet.getString("phoneNumber");
                String email=resultSet.getString("email");
                String classroom=resultSet.getString("classroom");
                students.add(new Student(id,name,dateOfBirth,address,phoneNumber,email,classroom));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return students;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_STUDENTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL)){
            statement.setString(1,student.getName());
            statement.setString(2,student.getDateOfBirth());
            statement.setString(3,student.getAddress());
            statement.setString(4,student.getPhoneNumber());
            statement.setString(5,student.getEmail());
            statement.setString(6,student.getClassroom());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
