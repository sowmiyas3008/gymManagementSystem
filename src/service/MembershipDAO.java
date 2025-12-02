package service;

import entity.Membership;
// import service.MembershipDAO_INT;
import java.util.*;
import java.sql.*;
// import java.time.LocalDate;
import util.DBConnection;

public class MembershipDAO implements MembershipDAO_INT {

    private DBConnection db;

    public MembershipDAO() {
        this.db = new DBConnection();
    }

    public boolean add_mps(Membership mp) {
        String sql = "INSERT INTO memberships (ms_id,mem_id,plan_id,s_date,e_date) VALUES(?,?,?,?,?)";
        try (Connection conn = db.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, mp.getMsid());
            ps.setInt(2, mp.getMemid());
            ps.setInt(3, mp.getPlanid());
            ps.setDate(4, java.sql.Date.valueOf(mp.getSdate()));
            ps.setDate(5, java.sql.Date.valueOf(mp.getEdate()));

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

    public List<Membership> getActiveMemberships(){
        List<Membership> list = new ArrayList<>();
        String sql = "SELECT * FROM memberships WHERE s_date <= CURDATE() AND e_date >= CURDATE()";
        try (Connection conn = db.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            // ps.setInt(1,mid);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Membership mp = new Membership(rs.getInt("ms_id"),
                rs.getInt("mem_id"),
                rs.getInt("plan_id"),
                rs.getDate("s_date").toLocalDate(),
                rs.getDate("e_date").toLocalDate()
                );

                list.add(mp);

            }


        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return list;
    }

}
