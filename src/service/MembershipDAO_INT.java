package service;

// import java.time.LocalDate;
import java.util.*;
import entity.Membership;

public interface MembershipDAO_INT {

    boolean add_mps(Membership mp);
    List<Membership> getActiveMemberships();
    // boolean updateMembershipE_date(LocalDate e_date);
    
}
