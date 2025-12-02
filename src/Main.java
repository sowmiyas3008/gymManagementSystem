
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import entity.Member;
import service.MemberDAO_INT;
import service.MemberDAO;

import entity.Trainer;
import service.TrainerDAO_INT;
import service.TrainerDAO;

import entity.WorkoutPlan;
import service.WorkoutPlanDAO_INT;
import service.WorkoutPlanDAO;

import entity.Membership;
import service.MembershipDAO;
import service.MembershipDAO_INT;

import Exception.MemberExists;

public class Main {

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // StudentDAO dao = new StudentDAO(); // No DB credentials here

        // while (true) {

        // System.out.println("\n===== STUDENT MENU =====");
        // System.out.println("1 → Add Student");
        // System.out.println("2 → View Student by ID");
        // System.out.println("3 → View All Students");
        // System.out.println("4 → Update Student");
        // System.out.println("5 → Delete Student");
        // System.out.println("6 → Exit");
        // System.out.print("Enter choice: ");

        // int ch = sc.nextInt();
        // sc.nextLine();

        // switch (ch) {

        // case 1:
        // System.out.print("Enter ID: ");
        // int id = sc.nextInt();
        // sc.nextLine();
        // System.out.print("Enter Name: ");
        // String name = sc.nextLine();
        // System.out.print("Enter Age: ");
        // int age = sc.nextInt();

        // dao.insert(new Student(id, name, age));
        // break;

        // case 2:
        // System.out.print("Enter ID: ");
        // dao.getStudentById(sc.nextInt());
        // break;

        // case 3:
        // dao.getAllStudents();
        // break;

        // case 4:
        // System.out.print("Enter ID to Update: ");
        // int uid = sc.nextInt();
        // sc.nextLine();
        // System.out.print("New Name: ");
        // String newName = sc.nextLine();
        // System.out.print("New Age: ");
        // int newAge = sc.nextInt();

        // dao.updateStudent(new Student(uid, newName, newAge));
        // break;

        // case 5:
        // System.out.print("Enter ID to Delete: ");
        // dao.deleteStudent(sc.nextInt());
        // break;

        // case 6:
        // System.out.println("Bye!");
        // return;

        // default:
        // System.out.println("Invalid choice!");
        // }
        // }

        Scanner sc = new Scanner(System.in);
        MemberDAO_INT mdao = new MemberDAO();
        TrainerDAO_INT tdao = new TrainerDAO();
        WorkoutPlanDAO_INT wpdao = new WorkoutPlanDAO();
        MembershipDAO_INT mpdao = new MembershipDAO();

        int mid = 0;
        int tid = 0;
        int wpid = 0;
        int msid = 0;

        while (true) {
            System.out.println("1.Add member ");
            System.out.println("2.View all Members ");
            System.out.println("3. View Member by ID");
            System.out.println("4. Update membership");
            System.out.println("5. Delete member ");
            System.out.println("6. Add trainer ");
            System.out.println("7. View trainer by specialization ");
            System.out.println("8. Add Workout Plan ");
            System.out.println("9. Get plans by Member ");
            System.out.println("10. Add membership details ");
            System.out.println("11. Get active memberships");

            System.out.print("Enter a choice: ");

            int n = sc.nextInt();

            switch (n) {

                case 1:
                    System.out.print("Enter MemberID: ");
                    mid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Contact: ");
                    int cont = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Membership type:");
                    String type = sc.nextLine();
                    System.out.print("Enter trainer id: ");
                    tid = sc.nextInt();

                    Member m = new Member(mid, name, age, cont, type, tid);

                    try{
                    System.out.println(mdao.add_mem(m) ? "Member added" : "failed to add");
                    }catch(MemberExists e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    List<Member> mlist = mdao.show_mem();
                    mlist.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter id: ");
                    Member m1 = mdao.view_mem(sc.nextInt());
                    System.out.println(m1 != null ? m1 : "Not found");
                    break;

                case 4:
                    System.out.print("Enter id");
                    mid = sc.nextInt();
                    System.out.print("Enter membership type: ");
                    String mtype = sc.next();
                    Member m2 = new Member(mtype, mid);
                    System.out.print(mdao.update_type(m2) ? "membership updated" : "not found");
                    break;

                case 5:
                    System.out.println("Enter id: ");
                    System.out.println(mdao.del_mem(sc.nextInt()) ? "Member deleted" : "not found");

                case 6:
                    System.out.println("Enter id: ");
                    tid = sc.nextInt();
                    System.out.println("Enter name: ");
                    String tname = sc.next();
                    System.out.println("Enter specialization in: ");
                    String special = sc.next();
                    System.out.println("Enter experience: ");
                    int experience = sc.nextInt();
                    Trainer m3 = new Trainer(tname, tid, special, experience);
                    System.out.println(tdao.add_trainer(m3) ? "Trainer added" : "not added");
                    break;

                case 7:
                    System.out.println("Enter specialization: ");
                    List<Trainer> stlist = tdao.show_bySpecialization(sc.next());
                    stlist.forEach(System.out::println);
                    break;

                case 8:
                    System.out.print("Enter plan ID: ");
                    wpid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter trainer ID: ");
                    tid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter member ID: ");
                    mid = sc.nextInt();
                    sc.nextLine();

                    WorkoutPlan wp = new WorkoutPlan(wpid, tid, mid);
                    System.out.println(wpdao.add_plan(wp) ? "added successfully" : "not added");
                    break;

                case 9:

                    System.out.print("Enter trainer id: ");
                    tid = sc.nextInt();
                    sc.nextLine();
                    List<WorkoutPlan> list = wpdao.getPlansByTrainer(tid);
                    list.forEach(System.out::println);
                    break;

                case 10:

                    System.out.print("Enter membership ID: ");
                    msid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter member ID: ");
                    mid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter plan ID: ");
                    wpid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter start date: ");
                    String sd = sc.nextLine();
                    LocalDate s_date = LocalDate.parse(sd);
                    System.out.print("Enter end date: ");
                    String ed = sc.nextLine();
                    LocalDate e_date = LocalDate.parse(ed);
                    Membership mp = new Membership(msid, mid, wpid, s_date, e_date);
                    System.out.println(mpdao.add_mps(mp) ? "membership added" : "not added");
                    break;

                case 11:

                    List<Membership> lists = mpdao.getActiveMemberships();
                    lists.forEach(System.out::println);
                    break;

                

            }

        }

    }
}