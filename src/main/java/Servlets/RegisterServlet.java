package Servlets;

import dao.H2.H2UserDao;
import dao.UserDao;
import model.User;
import sun.util.calendar.BaseCalendar;

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

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public static final String USER = "User";
    private UserDao userDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
       userDao=(UserDao)config.getServletContext().getAttribute("UserDao");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname=request.getParameter("firstName");
        String lastname=request.getParameter("lastName");
        String patronymic=request.getParameter("patronymic");
        String gender=request.getParameter("gender");
        String nickname=request.getParameter("nickname");
        Date date=Date.valueOf(request.getParameter("dob"));
        LocalDate dob=date.toLocalDate();
        String telephone=request.getParameter("telephone");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        Double height=Double.valueOf(request.getParameter("height"));
        Double weight=Double.valueOf(request.getParameter("weight"));
        String country=request.getParameter("country");
        String city=request.getParameter("city");
        String status=request.getParameter("status");
        int rating=0;

        User user=new User(1,firstname,lastname,patronymic,gender,nickname,dob,telephone,email,password,height,weight,country,city,status,rating);
        System.out.print(user.toString());
        userDao.create(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);
    }
}
