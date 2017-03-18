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
import java.util.List;

@WebServlet(name = "AddFriendServlet")
public class AddFriendServlet extends HttpServlet {
    private FriendDao friendDao;
    private UserDao userDao;
    public void init(ServletConfig config) throws ServletException {
        friendDao = (FriendDao) config.getServletContext().getAttribute("FriendDao");
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idFriend = Integer.valueOf(request.getParameter("addFriend"));
        User user = (User) request.getSession().getAttribute("user");
        RequestDispatcher requestDispatcher;
        if (user != null) {
            friendDao.addFriend(user.getId(), idFriend);
            friendDao.addFriend(idFriend, user.getId());
            List<Integer> friendsId = friendDao.getFriendsId(user.getId());
            requestDispatcher = request.getRequestDispatcher("/friends.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request, response);
    }
}
