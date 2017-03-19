package Servlets;

import dao.MessageDao;
import dao.UserDao;
import model.Message;
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

@WebServlet(name = "DeleteMessageServlet")
public class DeleteMessageServlet extends HttpServlet {
    private MessageDao messageDao;
    private UserDao userDao;

    public void init(ServletConfig config) throws ServletException {
        messageDao = (MessageDao) config.getServletContext().getAttribute("MessageDao");
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idMessage = Integer.valueOf(request.getParameter("deleteMessage"));
        User user = (User) request.getSession().getAttribute("user");
        RequestDispatcher requestDispatcher;
        if (user != null) {
            messageDao.deleteMessage(idMessage);
            List<Message> inMessages = messageDao.inMessagesOfUser(user);
            List<Message> outMessages = messageDao.outMessagesOfUser(user);
            request.getSession().setAttribute("inMessages", inMessages);
            request.getSession().setAttribute("outMessages", outMessages);
            requestDispatcher = request.getRequestDispatcher("/inMessages.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request, response);
    }
}