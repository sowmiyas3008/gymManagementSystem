package service;

// import service.WorkoutPlanDAO_INT;

import java.sql.PreparedStatement;

import entity.WorkoutPlan;
import util.DBConnection;
import java.sql.*;
import java.util.*;

public class WorkoutPlanDAO implements WorkoutPlanDAO_INT {

    private DBConnection db;

    public WorkoutPlanDAO() {
        this.db = new DBConnection();
    }

    public boolean add_plan(WorkoutPlan wp) {
        String sql = "INSERT INTO workoutPlans(plan_id,trainer_id,mem_id) VALUES(?,?,?)";
        try (Connection conn = db.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, wp.getWpid());
            ps.setInt(2, wp.getTid());
            ps.setInt(3, wp.getMid());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public List<WorkoutPlan> getPlansByTrainer(int id){
        String sql = "SELECT * FROM workoutPlans WHERE trainer_id = ?";
        List<WorkoutPlan> list = new ArrayList<>();
        try (Connection conn = db.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {


                    ps.setInt(1,id);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        WorkoutPlan wp = new WorkoutPlan(
                            rs.getInt("plan_id"),
                            rs.getInt("trainer_id"),
                            rs.getInt("mem_id")

                        );

                        list.add(wp);
                    }

                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

                return list;
    
    }

}
