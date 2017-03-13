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
import java.util.List;
import java.util.Optional;

@WebServlet(name = "SignInServlet")
public class SignInServlet extends HttpServlet {
    public static final String USER = "User";
    private UserDao userDao;
    public void init(ServletConfig config) throws ServletException {
        userDao=(UserDao)config.getServletContext().getAttribute("UserDao");
        //gunDao = (GunDao) config.getServletContext().getAttribute("GunDao");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login=request.getParameter("email");
        String password=request.getParameter("password");
        User user=new User();
        List<User> users=userDao.getAll();
        for(User u:users)
        {
            if (u.getEmail().equals(login)){
                user=u;
            }
        }

       /* String s = Optional.ofNullable(req.getSession().getAttribute(FIRST_NAME_KEY))
                .map(o -> String.format("Hello, %s!", o))
                .orElse("Hello!");*/
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/fitnesGuid.jsp");
        requestDispatcher.forward(request, response);
    }
}
