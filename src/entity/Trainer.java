package entity;

public class Trainer {
    private String name;
    private int id;
    private String special;
    private int experience;
    


public Trainer(String name, int id, String special, int experience){
    this.name = name;
    this.id = id;
    this.special = special;
    this.experience = experience;
}

public int getId() { return id; }
public String getName() { return name; }
public String getSpecial() { return special; }
public int getExperience() { return experience; }
@Override public String toString(){
    return name+" | "+id+" | "+special+" | "+experience;
}
}

