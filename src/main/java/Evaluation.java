import java.util.ArrayList;

public class Evaluation {
    private Personne personne;
    private int note;

    public Evaluation(Personne personne, int note) {
        this.personne = personne;
        this.note = note;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
