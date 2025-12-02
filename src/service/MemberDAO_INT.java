package service;
import entity.Member;
import java.util.*;
import Exception.MemberExists;

public interface MemberDAO_INT {
    boolean add_mem(Member m) throws MemberExists;
    List<Member> show_mem();
    Member view_mem(int id);
    boolean update_type(Member m);
    boolean del_mem(int id);

}
