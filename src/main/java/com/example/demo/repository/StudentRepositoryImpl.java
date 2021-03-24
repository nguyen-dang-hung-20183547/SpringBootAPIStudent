package com.example.demo.repository;

import com.example.demo.model.Student;
import com.example.demo.model.StudentCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    DataSource dataSource;


    public void releaseConn(Connection conn){
        try {
            if(conn!=null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void releaseResource(PreparedStatement ps, ResultSet rs){
        try {
            if(ps!=null) {
                ps.close();
            }
            if(rs != null){
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



    @Override
    public Student findById(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM student WHERE student_id = ?";
        Student s = null;
        try
        {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()) {
                int studentId = rs.getInt("student_id");
                String studentName = rs.getString("student_name");
                String studentAddress = rs.getString("student_address");
                int studentScore = rs.getInt("student_score");
                s = new Student(studentId,studentName,studentAddress,studentScore);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            releaseResource(ps,rs);
            releaseConn(conn);
        }
        return s;
    }

    @Override
    public Iterable<Student> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        Connection conn = null;
        boolean check = false;
        PreparedStatement ps = null;
        String sql = "DELETE FROM student WHERE student_id=?;";
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            int executeUpdate = ps.executeUpdate();
            if(executeUpdate == 1){
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            releaseResource(ps,null);
            releaseConn(conn);
        }
        return check;
    }

    @Override
    public boolean insert(StudentCreateModel s) {
        Connection conn = null;
        boolean check = false;
        PreparedStatement ps = null;
        String sql = "INSERT INTO student(student_name,student_address,student_score)VALUES(?,?,?);";
        try{
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, s.getStudentName());
            ps.setString(2, s.getStudentAddress());
            ps.setInt(3, s.getStudentScore());
            int executeUpdate = ps.executeUpdate();
            if(executeUpdate == 1){
                check = true;
            }
        } catch (Exception e) {
            //logger
        }
        finally {
            releaseConn(conn);
            releaseResource(ps,null);
        }
        return check;
    }

    @Override
    public boolean update(int id,StudentCreateModel s) {
        Connection conn = null;
        boolean check = false;
        PreparedStatement ps = null;
        String sql = "UPDATE student SET student_name =?, student_address = ?, student_score = ? WHERE student_id =?";
        try{
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,s.getStudentName());
            ps.setString(2,s.getStudentAddress());
            ps.setInt(3,s.getStudentScore());
            ps.setInt(4,id);
            int executeUpdate = ps.executeUpdate();
            if(executeUpdate == 1){
                check = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            releaseResource(ps,null);
            releaseConn(conn);
        }
        return check;
    }
    @Override
    public List<Student> getTopScore(int top){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student ORDER BY student_score DESC LIMIT ?";
        try{
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,top);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Student(
                        rs.getInt("student_id"),
                        rs.getString("student_name"),
                        rs.getString("student_address"),
                        rs.getInt("student_score")
                    )
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            releaseResource(ps,rs);
            releaseConn(conn);
        }
        System.out.println(list);
        return list;
    }
}
