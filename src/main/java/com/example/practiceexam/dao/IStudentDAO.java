package com.example.practiceexam.dao;

import com.example.practiceexam.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    public void insertStudent(Student students) throws SQLException;

    public Student selectStudent(int id);

    public List<Student> selectAllStudents();

    public boolean deleteStudent(int id) throws SQLException;

    public boolean updateStudent(Student student) throws SQLException;
}
