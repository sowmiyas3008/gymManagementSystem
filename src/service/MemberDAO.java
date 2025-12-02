package service;
import entity.Member;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Exception.MemberExists;
import java.sql.SQLException;

import java.util.*;

public class MemberDAO implements MemberDAO_INT{

    private DBConnection db;

    public MemberDAO() {
        this.db = new DBConnection();
    }

    public boolean add_mem(Member m) throws MemberExists{
        String check = "Select mid from members where mid = ?";
        String sql = "INSERT INTO members(mid, name, age, contact, mem_type,trainer_id) values(?,?,?,?,?)";
        try (Connection conn = db.getConnection();
                PreparedStatement ps1 = conn.prepareStatement(check)) {

                ps1.setInt(1,m.getId());
                ResultSet rs = ps1.executeQuery();

                if(rs.next()){
                    throw new MemberExists("member id" +m.getId()+ " already exists");
                }

                PreparedStatement ps2 = conn.prepareStatement(sql);


            ps2.setInt(1, m.getId());
            ps2.setString(2, m.getName());
            ps2.setInt(3, m.getAge());
            ps2.setInt(4, m.getContact());
            ps2.setString(5, m.getType());
            ps2.setInt(6,m.getTid());


            int rows = ps2.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

    public List<Member> show_mem() {
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM members";
        try (Connection conn = db.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                Member m = new Member(
                        rs.getInt("mid"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getInt("contact"),
                        rs.getString("mem_type"),
                        rs.getInt("trainer_id")

                );

                list.add(m);
            }
        } catch (Exception e) {
            System.out.println("error occured in viewing all");
            return null;
        }

        return list;

    }

    public Member view_mem(int id) {
        String sql = "Select * from members where mid = ?";
        try (Connection conn = db.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                return new Member(
                        rs.getInt("mid"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getInt("contact"),
                        rs.getString("mem_type"),
                        rs.getInt("trainer_id")


                );
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public boolean update_type(Member m) {
        String sql = "UPDATE members set mem_type = ? where mid = ?";
        try (Connection conn = db.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(2, m.getId());
            ps.setString(1, m.getType());
            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean del_mem(int id) {
        String sql = "DELETE FROM members where mid = ?";
        try(Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

                ps.setInt(1,id);
                int rows = ps.executeUpdate();

                return rows>0;


            }catch(Exception e){
                System.out.println(e.getMessage());
            }

            return false;
    }

 

    // // DELETE
    // public void deleteStudent(int id) {
    // String sql = "DELETE FROM students WHERE id=?";
    // try (Connection conn = db.getConnection();
    // PreparedStatement ps = conn.prepareStatement(sql)) {

    // ps.setInt(1, id);

    // int rows = ps.executeUpdate();
    // if (rows > 0)
    // System.out.println("Student Deleted!");
    // else
    // System.out.println("Student Not Found!");

    // } catch (Exception e) {
    // System.out.println("Delete Error: " + e.getMessage());
    // }
    // }
}