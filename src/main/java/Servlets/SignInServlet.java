package Servlets;

import dao.FriendDao;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "SignInServlet")
public class SignInServlet extends HttpServlet {
    public static final String USER = "User";
    private UserDao userDao;
    private FriendDao friendDao;

    public void init(ServletConfig config) throws ServletException {

        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
        friendDao = (FriendDao) config.getServletContext().getAttribute("FriendDao");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("invalidEmail");
        request.getSession().removeAttribute("invalidPassword");
        String login = request.getParameter("email");
        String password = request.getParameter("password");
        User user;
        RequestDispatcher requestDispatcher;
        user = Optional.ofNullable(userDao.getUserByLogin(login)).get().orElse(null);
        if (user != null)
            if (user.getPassword().equals(password)) {
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
                requestDispatcher = request.getRequestDispatcher("/friends.jsp");
                List<User> rating = userDao.rating();
                List<Integer> friendsId = friendDao.getFriendsId(user.getId());
                List<User> friends = new ArrayList<>();
                friendsId.stream().forEach(id -> friends.add(userDao.get(id).get()));
                request.getSession().setAttribute("friends", friends);
                request.getSession().setAttribute("rating", rating);
            } else {
                request.getSession().setAttribute("invalidPassword", "Yes");
                requestDispatcher = request.getRequestDispatcher("/login.jsp");
            }
        else {
            request.getSession().setAttribute("invalidEmail", "Yes");
            requestDispatcher = request.getRequestDispatcher("/login.jsp");
        }

        requestDispatcher.forward(request, response);

    }
}
