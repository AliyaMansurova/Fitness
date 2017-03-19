package Servlets;

import dao.MissionDao;
import dao.TrainingDao;
import dao.UserDao;
import model.Message;
import model.Mission;
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

@WebServlet(name = "MyMissionsServlet")
public class MyMissionsServlet extends HttpServlet {
    private MissionDao missionDao;
    private UserDao userDao;
    private TrainingDao trainingDao;

    public void init(ServletConfig config) throws ServletException {
        missionDao = (MissionDao) config.getServletContext().getAttribute("MissionDao");
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
        trainingDao=(TrainingDao)config.getServletContext().getAttribute("TrainingDao");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        User user;
        user = (User) request.getSession().getAttribute("user");
        if(user.getStatus_code().equals("Trainer")){
            request.getSession().setAttribute("trainer","yes");
            List<Integer> mySportsmansId = trainingDao.getSportsmansId(user.getId());
            List<User> mySportsmans = new ArrayList<>();
            mySportsmansId.stream().forEach(id -> mySportsmans.add(userDao.get(id).get()));
            request.getSession().setAttribute("mySportsmans", mySportsmans);
            List<Mission>missionsForMySportsmans=missionDao.getTasksForSportsmans(user);
            request.getSession().setAttribute("missionsForMySportsmans", missionsForMySportsmans);
        }
        List<Integer> myTrainersId = trainingDao.getTrainersId(user.getId());
        List<User> myTrainers = new ArrayList<>();
        myTrainersId.stream().forEach(id -> myTrainers.add(userDao.get(id).get()));
        request.getSession().setAttribute("myTrainers",myTrainers);
            List<Mission> achievments = missionDao.getAchievements(user);
            List<Mission> tasks = missionDao.getTasks(user);
            String path=request.getParameter("task");
            request.getSession().setAttribute("tasks", tasks);
            request.getSession().setAttribute("achievments", achievments);
            requestDispatcher = request.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
    }
}
