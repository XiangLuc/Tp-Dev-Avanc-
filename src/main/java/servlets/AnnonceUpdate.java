package servlets;

import dao.AnnonceDAO;
import models.Annonce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/annonce/update")
public class AnnonceUpdate extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            response.sendRedirect("AnnonceList");
            return;
        }

        int id = Integer.parseInt(idParam);

        try {
            AnnonceDAO annonceDAO = new AnnonceDAO();
            Annonce annonce = annonceDAO.find(id);

            if (annonce != null) {
                request.setAttribute("annonce", annonce);
                request.getRequestDispatcher("/AnnonceUpdate.jsp").forward(request, response);
            } else {
                response.sendRedirect("liste");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("AnnonceList");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String adress = request.getParameter("adress");
        String mail = request.getParameter("mail");

        Annonce annonce = new Annonce(id, title, description, adress, mail, new Timestamp(System.currentTimeMillis()));

        try {
            AnnonceDAO annonceDAO = new AnnonceDAO();
            boolean success = annonceDAO.update(annonce);

            if (success) {
                response.sendRedirect("liste");
            } else {
                request.setAttribute("error", "Erreur lors de la mise à jour de l'annonce");
                request.getRequestDispatcher("/AnnonceUpdate.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Une erreur est survenue");
            request.getRequestDispatcher("/AnnonceUpdate.jsp").forward(request, response);
        }
    }
}
