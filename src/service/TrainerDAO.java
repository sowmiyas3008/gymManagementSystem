package service;

import entity.Trainer;
import util.DBConnection;
import java.util.*;

import java.sql.*;
// import java.util.*;

public class TrainerDAO implements TrainerDAO_INT {

    private DBConnection db;

    public TrainerDAO() {
        this.db = new DBConnection();
    }

    public boolean add_trainer(Trainer t) {
        String sql = "INSERT INTO trainers(name,id,specialization,experience) values(?,?,?,?)";
        try (Connection conn = db.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, t.getName());
            ps.setInt(2, t.getId());
            ps.setString(3, t.getSpecial());
            ps.setInt(4, t.getExperience());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public List<Trainer> show_bySpecialization(String special) {
        List<Trainer> list = new ArrayList<>();
        String sql = "Select * from trainers where specialization = ?";
        try (Connection conn = db.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            
            ps.setString(1,special);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Trainer t = new Trainer(
                        rs.getString("name"),
                        rs.getInt("id"),
                        rs.getString("specialization"),
                        rs.getInt("experience"));

                list.add(t);
            }
            return list;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

}
