package Servlets;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet(name = "EditServlet")
public class EditServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getSession().getAttribute("path").toString();
        int id = (Integer) request.getSession().getAttribute("id");
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
        int rating = (Integer) request.getSession().getAttribute("rating");
        User user;
        if (email.equals(request.getSession().getAttribute("email"))) {
            user = new User(id, firstname, lastname, patronymic, gender, dob, telephone, email, password, height, weight, country, city, status, rating);
            request.getSession().setAttribute("edited", "edited");
            request.getSession().removeAttribute("freeLogin");
        } else {
            if (userDao.LoginFree(email)) {
                user = new User(id, firstname, lastname, patronymic, gender, dob, telephone, email, password, height, weight, country, city, status, rating);
                userDao.update(user);
                request.getSession().setAttribute("edited", "edited");
                request.getSession().removeAttribute("freeLogin");
            } else {
                user = (User) request.getSession().getAttribute("user");
                request.getSession().setAttribute("freeLogin", "LoginNotFree");
                request.getSession().removeAttribute("edited");
            }
        }
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("id", user.getId());
        request.getSession().setAttribute("firstName", user.getFirstName());
        request.getSession().setAttribute("lastName", user.getLastName());
        request.getSession().setAttribute("patronymic", user.getPatronymic());
        request.getSession().setAttribute("dob", user.getDob());
        request.getSession().setAttribute("gender", user.getGender_code());
        request.getSession().setAttribute("telephone", user.getTelephone());
        request.getSession().setAttribute("email", user.getEmail());
        request.getSession().setAttribute("password", user.getPassword());
        request.getSession().setAttribute("height", user.getHeight());
        request.getSession().setAttribute("weight", user.getWeight());
        request.getSession().setAttribute("country", user.getCountry());
        request.getSession().setAttribute("city", user.getCity());
        request.getSession().setAttribute("status", user.getStatus_code());
        request.getSession().setAttribute("rating", user.getRating());
        request.getRequestDispatcher(path).forward(request, response);
    }

}


