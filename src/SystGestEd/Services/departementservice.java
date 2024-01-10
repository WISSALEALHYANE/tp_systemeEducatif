package SystGestEd.Services;
import SystGestEd.Module.Enseignant;
import SystGestEd.Module.Departement;

import java.util.ArrayList;

public class departementservice {


    public static Departement addDept(String intitule , Enseignant... responsable){
        Departement departement =new Departement();
        departement.setIntitulé(intitule);
        departement.setId(DB.getDeptId());
        if(responsable.length>0){
            departement.setresponsable(responsable[0]);
        }
        DB.departements.add(departement);
        return departement;

    }
    public static Departement updateDept(int id,String intitule,Enseignant... responsable){
        for (Departement departement :DB.departements){
            if(departement.getId()==id){
                departement.setIntitulé(intitule);
                if(responsable.length>0){
                    departement.setresponsable(responsable[0]);
                }
                return departement;
            }
        }
        return new Departement();
    }
    public static ArrayList<Departement> deleteDeptById(int id){
        DB.departements.remove(getDeptById(id));
        return DB.departements;
    }
    public static Departement getDeptById(int id){
        for (Departement departement :DB.departements){
            if(departement.getId()==id)
                return  departement;
        }
        return new Departement();
    }
    public static ArrayList<Departement> getAllDept(){
        return DB.departements;
    }
}
