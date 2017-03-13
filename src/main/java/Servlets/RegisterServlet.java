package Servlets;

import dao.H2.H2UserDao;
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
import java.util.List;
import java.util.Locale;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
  /*  public static final String LOGIN = "Welcome";
    public static final String PASSWORD = "AllGuns";*/
    public static final String USER = "User";
    private UserDao userDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
       userDao=(UserDao)config.getServletContext().getAttribute("UserDao");
        //gunDao = (GunDao) config.getServletContext().getAttribute("GunDao");
    }
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String patronymic=request.getParameter("patronymic");
        String nickname=request.getParameter("nickname");
        /*String dob=request.getParameter("dob").toLocalDate();
        String telephone=request.getParameter("telephone");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String status=request.getParameter("status");
        User user=new User(2,firstname,lastname,patronymic,nickname,telephone,email,password,status);
        userDao.create(user);*/
        request.setAttribute(USER,userDao.getAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registration/login.jsp");
        requestDispatcher.forward(request, response);
        /*String login = request.getParameter("login");
        String password=request.getParameter("password");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registration/login.jsp");
        request.setAttribute(LOGIN, login);
        request.setAttribute(PASSWORD, password);
        requestDispatcher.forward(request, response);*/
    }
}
