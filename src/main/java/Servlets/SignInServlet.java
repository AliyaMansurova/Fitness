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
import java.util.Optional;

@WebServlet(name = "SignInServlet")
public class SignInServlet extends HttpServlet {
    public static final String USER = "User";
    private UserDao userDao;
    public void init(ServletConfig config) throws ServletException {
        userDao=(UserDao)config.getServletContext().getAttribute("UserDao");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login=request.getParameter("email");
        String password=request.getParameter("password");
        User user;
        RequestDispatcher requestDispatcher;
        user=Optional.ofNullable(userDao.getUserByLogin(login)).get().orElse(null);
        if (user != null)
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", "user");
                requestDispatcher = request.getRequestDispatcher("/fitnesGuid.jsp");
            } else requestDispatcher = request.getRequestDispatcher("/login.jsp");
        else {
            requestDispatcher = request.getRequestDispatcher("/step.jsp");
        }
        requestDispatcher.forward(request, response);

    }
}
