package service;
import entity.Trainer;
import java.util.*;

public interface TrainerDAO_INT {
    boolean add_trainer(Trainer t);
    List<Trainer> show_bySpecialization(String special);
    
}
