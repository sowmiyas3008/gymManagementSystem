package service;

import entity.WorkoutPlan;
import java.util.*;

public interface WorkoutPlanDAO_INT {
    boolean add_plan(WorkoutPlan wp);
    // List<WorkoutPlan> getPlansByMember(int id);
    List<WorkoutPlan> getPlansByTrainer(int id);
}
