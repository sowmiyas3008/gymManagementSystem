package entity;

public class WorkoutPlan {
    private int wpid;
    private int tid;
    private int mid;

    public WorkoutPlan(int wpid, int tid, int mid) {
        this.wpid = wpid;
        this.tid = tid;
        this.mid = mid;
    }

    public int getWpid() {
        return wpid;
    }

    public int getTid() {
        return tid;
    }

    public int getMid() {
        return mid;
    }

    @Override
    public String toString() {
        return "plan id = " + wpid + " | trainer_id= " + tid + " |member_id=  " + mid;
    }

}
