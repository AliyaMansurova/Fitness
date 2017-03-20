package Servlets;

import listeners.dbIniter;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "InitLangServlet")
public class InitLangServlet extends HttpServlet {
    public static Logger logger = Logger.getLogger(dbIniter.class.getName());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("locale",request.getParameter("locale"));
        logger.log(Level.INFO,String.format("Locale was changed"));
        String path=request.getSession().getAttribute("path").toString();
        request.getRequestDispatcher(path).forward(request, response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


}
