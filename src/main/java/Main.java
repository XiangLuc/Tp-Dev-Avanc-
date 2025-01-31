import dao.AnnonceDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AnnonceDAO dao = new AnnonceDAO();

        // Test du find pour vérifier si il trouve bien une annonce.
        System.out.println(dao.find(1).getAdress());
    }
}
