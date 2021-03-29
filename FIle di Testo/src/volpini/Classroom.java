package volpini;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Classroom implements Savable{
    private ArrayList<Studente> studenti;

    public Classroom() {
        studenti = new ArrayList<>();
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(ArrayList<Studente> studenti) {
        this.studenti = studenti;
    }
    public void aggiungi(Studente s){
        studenti.add(s);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Class<?> thisClass = null;
        try {
            thisClass = Class.forName(this.getClass().getName());

            Field[] aClassFields = thisClass.getDeclaredFields();
            sb.append(this.getClass().getSimpleName() + " [ ");
            for(Field f : aClassFields){
                String fName = f.getName();
                sb.append("(").append(f.getType()).append(") ").append(fName).append(" = ").append(f.get(this)).append(", ");
            }
            sb.append("]");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
