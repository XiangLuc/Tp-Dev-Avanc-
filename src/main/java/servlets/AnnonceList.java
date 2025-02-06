package servlets;

import dao.v2.AnnonceDAOv2;
import entities.Annonce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/annonce/liste")
public class AnnonceList extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AnnonceDAOv2 annonceDAO = new AnnonceDAOv2();

        List<Annonce> annonces = annonceDAO.list();

        request.setAttribute("annonces", annonces);

        request.getRequestDispatcher("/AnnonceList.jsp").forward(request, response);
    }
}