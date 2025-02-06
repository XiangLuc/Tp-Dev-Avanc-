package servlets;

import dao.v2.AnnonceDAOv2;
import entities.Annonce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/annonce/delete")
public class AnnonceDelete extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            response.sendRedirect("liste");
            return;
        }

        int id = Integer.parseInt(idParam);

        try {
            AnnonceDAOv2 annonceDAO = new AnnonceDAOv2();
            Annonce annonce = annonceDAO.find(id);
            if(annonce != null) {
                boolean success = annonceDAO.delete(annonce);

                if (success) {
                    response.sendRedirect("liste");
                } else {
                    request.setAttribute("error", "Erreur lors de la suppression de l'annonce");
                    request.getRequestDispatcher("AnnonceList.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Une erreur est survenue lors de la suppression");
            request.getRequestDispatcher("AnnonceList.jsp").forward(request, response);
        }
    }
}
