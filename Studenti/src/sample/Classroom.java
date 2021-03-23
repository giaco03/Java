package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Classroom implements Savable, Serializable {
    private List<Student> classe;

    public Classroom() {
        classe = new ArrayList<>();
    }
    public void addStudent(Student s){
        classe.add(s);
    }
    public void removeStudent(int i){

        if(i >= 0 && i < classe.size() ){
            classe.remove(i);
        }
    }

    public int size() {
        return classe.size();
    }

    public Student getStudent(int index) {
        return classe.get(index);
    }

    public void setStudent(Student s,int index) {
        classe.set(index,s);
    }

}