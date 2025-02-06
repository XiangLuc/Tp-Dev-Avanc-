package servlets;

import dao.v2.AnnonceDAOv2;
import entities.Annonce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/annonce/add")
public class AnnonceAdd extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/AnnonceAdd.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String adress = request.getParameter("adress");
        String mail = request.getParameter("mail");

        Annonce annonce = new Annonce(
                title,
                description,
                adress,
                mail,
                new Timestamp(System.currentTimeMillis())
        );

        AnnonceDAOv2 annonceDAO = new AnnonceDAOv2();
        annonceDAO.create(annonce);
        response.sendRedirect(request.getContextPath() + "/annonce/liste");
    }
}