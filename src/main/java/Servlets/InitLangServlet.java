package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "InitLangServlet")
public class InitLangServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s="ru_RU";
        request.getSession().setAttribute("locale",s);
        System.out.print("I am here");
        request.getSession().setAttribute("basename","local.local");
        request.getRequestDispatcher("/WEB-INF/index.jsp")
                .forward(request, response);
    }

}
