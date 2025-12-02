package entity;

public class Member {
    private int id;
    private String name;
    private int age;
    private int contact;
    private String type;
    private int tid;

    public Member(int id, String name, int age, int contact,String type, int tid ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.type = type;
        this.tid = tid;
    }
    public Member(String type, int id){
        this.id = id;
        this.type = type;
    }



    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getContact() {  return contact; }
    public String getType() { return type; }
    public int getTid(){ return tid; }
    @Override public String toString(){
        return id+" | "+name+" | "+age+" | "+contact+" | "+type+ " | " +tid;
    }

}
