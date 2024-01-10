package SystGestEd.login;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import static SystGestEd.Main.getIntInput;
import static SystGestEd.Main.getStringInput;

public class connectionDB {



    static Connection cnx;
    static Statement st;
    static ResultSet rst;


    public static void main(String[] args) {
      getEnsById();
    }



    public static Connection  connecterDB(){
        try{


            String url="jdbc:mysql://localhost:3306/jdbc-coonexion";
            String user="root";
            String password="toor";
            Connection cnx=DriverManager.getConnection(url,user,password);
            System.out.println("Connexion bien établie");
            return cnx;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static void getEnsById() {
        int id = getIntInput("entrez l'id du teacher:");
        try {
            String query = "SELECT * FROM enseignant WHERE id_ens='" + id + "'";
            cnx = connecterDB();
            st = cnx.createStatement();
            rst = st.executeQuery(query);
            rst.next();
            int nbrRow = rst.getRow();
            if (nbrRow != 0) {
                System.out.println("teacher well found");
                System.out.print(rst.getString("nom") + "\t");
                System.out.print(rst.getString("prenom") + "\t");
                System.out.print(rst.getString("email") + "\t");
                System.out.print(rst.getString("grade") + "\t");
                System.out.println();
            } else {
                System.out.println("teacher not found");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

        public static void addEns() {
            int id=getIntInput("entrez l'id du teacher:");
            String nom =getStringInput("entrez le nom du teacher :");
            String prenom =getStringInput("entrez le prenom du teacher:");
            String email =getStringInput("entrez l'email du teacher:");
            String grade =getStringInput("entrez la grade du teacher:");
            try{
                String query="INSERT INTO enseignant (id_ens,nom,prenom,email,grade) VALUES('"+id+"','"+nom+"','"
                        +prenom+"','"+email+"','"+grade+"')";
                cnx=connecterDB();
                st=cnx.createStatement();
                st.executeUpdate(query);
                System.out.println("well added teacher");

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }




    public static void modifierEns(){
        int id=getIntInput("entrez l'id du teacher:");
        String nom =getStringInput("entrez le nom du teacher :");
        String prenom =getStringInput("entrez le prenom du teacher:");
        String email =getStringInput("entrez l'email du teacher:");
        String grade =getStringInput("entrez la grade du teacher:");
        try{
            String query="UPDATE enseignant SET nom='"+nom
                    +"', prenom='"+prenom

                    +"', email='"+email
                    +"', grade='"+grade
                    +"' WHERE id_ens="+id;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well-modified teacher");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteEnsById(){
        int id=getIntInput("entrez un id du teacher:");
        try{
            String query="DELETE FROM enseignant WHERE id_ens="+id;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well deleted teacher");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

