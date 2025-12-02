package service;
import entity.Member;
import java.util.*;
import Exception.MemberExists;
import Exception.MemberNotFound;

public interface MemberDAO_INT {
    boolean add_mem(Member m) throws MemberExists;
    List<Member> show_mem();
    Member view_mem(int id) throws MemberNotFound;
    boolean update_type(Member m);
    boolean del_mem(int id);

}
