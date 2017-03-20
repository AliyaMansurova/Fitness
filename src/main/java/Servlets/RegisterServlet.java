package Servlets;

import dao.UserDao;
import listeners.dbIniter;
import model.User;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private UserDao userDao;
    public static Logger logger = Logger.getLogger(dbIniter.class.getName());
    @Override
    public void init(ServletConfig config) throws ServletException {
       userDao=(UserDao)config.getServletContext().getAttribute("UserDao");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        String patronymic = request.getParameter("patronymic");
        String gender = request.getParameter("gender");
        Date date = Date.valueOf(request.getParameter("dob"));
        LocalDate dob = date.toLocalDate();
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Double height;
        if (request.getParameter("height").isEmpty()) {
            height = 0.0;
        } else height = Double.valueOf(request.getParameter("height"));
        Double weight;
        if (request.getParameter("weight").isEmpty()) {
            weight = 0.0;
        } else
            weight = Double.valueOf(request.getParameter("weight"));
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String status = request.getParameter("status");
        int rating = 0;
        String path;
        if (userDao.LoginFree(email)) {
            User user = new User(1, firstname, lastname, patronymic, gender, dob, telephone, email, password, height, weight, country, city, status, rating);
            System.out.print(user.toString());
            userDao.create(user);
            logger.log(Level.INFO,"Registered new user");
            path = "/successfulRegistration.jsp";
            request.getSession().removeAttribute("freeLogin");
        } else {
        path = request.getSession().getAttribute("path").toString();
        request.getSession().setAttribute("freeLogin", "loginNotFree");
        }
        request.getRequestDispatcher(path).forward(request, response);
    }
}
