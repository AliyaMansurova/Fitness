package Servlets;

import dao.FriendDao;
import dao.TrainingDao;
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


@WebServlet(name = "AddTrainingServlet")
public class AddTrainingServlet extends HttpServlet {
    private TrainingDao trainingDao;
    private UserDao userDao;

    public void init(ServletConfig config) throws ServletException {
        trainingDao = (TrainingDao) config.getServletContext().getAttribute("TrainingDao");
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idSportsman = Integer.valueOf(request.getParameter("addSportsman"));
        User user = (User) request.getSession().getAttribute("user");
        RequestDispatcher requestDispatcher;
        trainingDao.addTraining(user.getId(), idSportsman);
        List<Integer> SportsmanId = trainingDao.getSportsmansId(user.getId());
        requestDispatcher = request.getRequestDispatcher("/friends.jsp");
        requestDispatcher.forward(request, response);
    }
}
