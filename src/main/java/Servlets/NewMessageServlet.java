package Servlets;

import dao.FriendDao;
import dao.MessageDao;
import dao.UserDao;
import listeners.dbIniter;
import model.Message;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NewMessageServlet")
public class NewMessageServlet extends HttpServlet {
    private FriendDao friendDao;
    private UserDao userDao;
    private MessageDao messageDao;
    public static Logger logger = Logger.getLogger(dbIniter.class.getName());
    public void init(ServletConfig config) throws ServletException {
        friendDao = (FriendDao) config.getServletContext().getAttribute("FriendDao");
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
        messageDao=(MessageDao)config.getServletContext().getAttribute("MessageDao");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user= (User) request.getSession().getAttribute("user");
        String friend=request.getParameter("friends");
        Integer id=Integer.valueOf(friend);
        User id_to=userDao.get(id).get();
        String text=request.getParameter("message");
        LocalDate today = LocalDate.now();
        Message newMessage=new Message(1,user,id_to,text,today);
        messageDao.newMessage(newMessage);
        List<Message> outMessages = messageDao.outMessagesOfUser(user);
        request.getSession().setAttribute("outMessages", outMessages);
        logger.log(Level.INFO,"User  created new message");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/newMessage.jsp");
        requestDispatcher.forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        User Iam=(User) request.getSession().getAttribute("user");
        List<Integer> friendsId = friendDao.getFriendsId(Iam.getId());
        List<User> friends = new ArrayList<>();
        friendsId.stream().forEach(id -> friends.add(userDao.get(id).get()));
        request.getSession().setAttribute("friends", friends);
        requestDispatcher = request.getRequestDispatcher("/newMessage.jsp");
        requestDispatcher.forward(request, response);
    }
}
