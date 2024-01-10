package SystGestEd.Services;
import SystGestEd.Module.Departement;
import SystGestEd.Module.Enseignant;
import SystGestEd.Module.Filiere;
import java.util.ArrayList;

import static SystGestEd.Services.DB.FIL_ID;
import static SystGestEd.Services.DB.departements;

public class filiereservice {
    public static Filiere addFiliere(String intitule, Enseignant responsable, Departement dept) {
        Filiere filiere=new Filiere();
        filiere.setIntitule(intitule);
        filiere.setResponsable(responsable);
        filiere.setDepartement(dept);
        filiere.setId(DB.getModId());
        DB.filieres.add(filiere);
        return  new Filiere();
    }

    public static Filiere updateFiliere(int id , String intitule, Enseignant responsable, Departement dept){
        for (Filiere filiere :DB.filieres){
            if(filiere.getId()==id){
                filiere.setIntitule(intitule);
                filiere.setIntitule(intitule);
                filiere.setResponsable(responsable);
                filiere.setDepartement(dept);

                return filiere;
            }
        }







        return  new Filiere();
    }
    public static ArrayList<Filiere> deleteFiliereById(int id){
        return  DB.filieres;
    }

    public static Filiere getFiliereById(int id){
        for (Filiere filiere:DB.filieres
             ) {
            if (id==FIL_ID){
                return filiere;
            }

        }
        return new Filiere();
    }

    public static ArrayList<Filiere> getAllFiliere(){
        return  DB.filieres;
    }
}
