package Servlets;

import dao.MissionDao;
import dao.UserDao;
import listeners.dbIniter;
import model.Mission;
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
import java.util.List;

@WebServlet(name = "DeleteMissionServlet")
public class DeleteMissionServlet extends HttpServlet {
    private MissionDao missionDao;
    private UserDao userDao;
    public static Logger logger = Logger.getLogger(dbIniter.class.getName());
    public void init(ServletConfig config) throws ServletException {
        missionDao = (MissionDao) config.getServletContext().getAttribute("MissionDao");
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idMission = Integer.valueOf(request.getParameter("deleteMission"));
        User user = (User) request.getSession().getAttribute("user");
        missionDao.deleteMission(idMission);
        logger.log(Level.INFO,"User deleted mission");
        List<Mission>missionsForMySportsmans=missionDao.getTasksForSportsmans(user);
        request.getSession().setAttribute("missionsForMySportsmans", missionsForMySportsmans);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/tasksForMySportsmans.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idMission = Integer.valueOf(request.getParameter("deleteMission"));
        User user = (User) request.getSession().getAttribute("user");
        missionDao.deleteMission(idMission);
        logger.log(Level.INFO,"User deleted mission");
        List<Mission> tasks = missionDao.getTasks(user);
        request.getSession().setAttribute("tasks", tasks);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/tasks.jsp");
        requestDispatcher.forward(request, response);
    }
}
