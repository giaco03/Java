package volpini;

import java.io.Serializable;

public class Studente implements Savable {
    private String name;
    private String surname;
    private int age;
    private char parsechar;

    public Studente(String name, String surname, int age, char parsechar) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.parsechar = parsechar;
    }
    public Studente(){
        name = "";
        surname = "";
        age = 0;
        parsechar = 'q';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name+"\n"+surname +"\n"+age +"\n" + parsechar + "\n";
    }


    public String toStringH() {
        return "Studente{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", char = " + parsechar +
                '}';
    }
}
