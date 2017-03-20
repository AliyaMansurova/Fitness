package Servlets;

import dao.FriendDao;
import dao.UserDao;
import listeners.dbIniter;
import model.User;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

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

@WebServlet(name = "AddFriendServlet")
public class AddFriendServlet extends HttpServlet {
    private FriendDao friendDao;
    private UserDao userDao;
    public static Logger logger = Logger.getLogger(dbIniter.class.getName());
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
        friendDao.addFriend(user.getId(), idFriend);
        friendDao.addFriend(idFriend, user.getId());
        List<Integer> friendsId = friendDao.getFriendsId(user.getId());
        List<User> friends = new ArrayList<>();
        friendsId.stream().forEach(id -> friends.add(userDao.get(id).get()));
        logger.log(Level.INFO,String.format("User %s %s adds friend",user.getFirstName(),user.getLastName()));
        request.getSession().setAttribute("friends", friends);
        requestDispatcher = request.getRequestDispatcher("/friends.jsp");
        requestDispatcher.forward(request, response);
    }
}
