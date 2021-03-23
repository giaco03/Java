package sample;

import java.io.Serializable;

import static java.lang.Integer.parseInt;

public class Student implements Serializable {
    private String name;
    private String surname;
    private int age;
    private String home;

    public Student(String name, String surname, String age, String home) {
        this.name = name;
        this.surname = surname;
        this.age = parse(age);
        this.home = home;
    }
    public int parse(String s){
        int i=0;
        try {
            i = parseInt(s);
            return i;
        }catch (NumberFormatException e) {
            System.out.println("Stringa non valida età messa a 0");
        }
        return i;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
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




    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + getAge();
        result = 31 * result + (getHome() != null ? getHome().hashCode() : 0);
        return result;
    }
}
