package patatina;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Classe{
    private ArrayList<Studente> studenti;

    public Classe() {
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
        String app = "";
        for(Studente studente : studenti) app += studente.toString();
        return app;
    }
}
