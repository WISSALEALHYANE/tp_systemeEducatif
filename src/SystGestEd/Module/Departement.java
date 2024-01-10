package SystGestEd.Module;
import java.util.ArrayList;
public class Departement {
    private int id;
        private String intitulé;
        private Enseignant responsable;
    ArrayList<Filiere> filieres = new ArrayList<Filiere>();
    public Departement(){

    }

    public Departement(String intitulé, Enseignant responsable) {
        this.intitulé = intitulé;
        this.responsable = responsable;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getIntitulé() {
        return intitulé;
    }
    public void setIntitulé(String intitulé) {
        this.intitulé = intitulé;
    }
    public Enseignant getresponsable() {
        return responsable;
    }
    public void setresponsable(Enseignant responsable) {
        this.responsable = responsable;}
    public ArrayList<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(ArrayList<Filiere> filieres) {
        this.filieres = filieres;
    }
}



