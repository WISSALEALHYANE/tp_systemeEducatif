package SystGestEd.Services;
import SystGestEd.Module.Enseignant;
import SystGestEd.Module.Filiere;
import SystGestEd.Module.Module;
import java.util.ArrayList;
import java.util.List;

import static SystGestEd.Services.DB.MOD_ID;
import static SystGestEd.Services.DB.modules;

public class moduleservice {
    public static Module addModule(String intitule, Enseignant professeur, Filiere filiere) {
        Module module =new Module();
        module.setIntitule(intitule);
        module.setProfesseur(professeur);
        module.setFiliere(filiere);
        module.setId(DB.getModId());
        DB.modules.add(module);
        return  new Module();
    }

    public static Module updateModule(int id , String intitule, Enseignant professeur,  Filiere filiere){
        for (Module module :DB.modules){
            if(module.getId()==id){
                module.setIntitule(intitule);

                return module;
            }
        }


        return  new Module();
    }
    public static ArrayList<Module> deleteModuleById(int id){
        return  modules;
    }

    public static Module getModuleById(int id){
        for (Module module:
             DB.modules
             ) {
            if (id==MOD_ID){return module;}

        }
        return
                new Module();
    }

    public static ArrayList<Module> getAllModule(){
        return  modules;
    }
}
