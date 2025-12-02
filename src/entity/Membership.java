package entity;

import java.time.LocalDate;

public class Membership {
    private int msid;
    private int mem_id;
    private int plan_id;
    private LocalDate s_date;
    private LocalDate e_date;

    public Membership(int membershipId, int memberId, int planId,
            LocalDate startDate, LocalDate endDate) {

        this.msid = membershipId;
        this.mem_id = memberId;
        this.plan_id = planId;
        this.s_date = startDate;
        this.e_date = endDate;
    }

    public int getMsid() {
        return msid;
    }

    public int getMemid() {
        return mem_id;
    }

    public int getPlanid() {
        return plan_id;
    }

    public LocalDate getSdate() {
        return s_date;
    }

    public LocalDate getEdate() {
        return e_date;
    }

    @Override
    public String toString() {
        return "mps id = " + msid + " | planid= " + plan_id + " |member_id=  " + mem_id + " |end date " + e_date;

    }

}
