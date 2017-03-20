package Servlets;

import dao.FriendDao;
import dao.MessageDao;
import dao.MissionDao;
import dao.UserDao;
import listeners.dbIniter;
import model.Message;
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
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "NewTaskServlet")
public class NewTaskServlet extends HttpServlet {
    private UserDao userDao;
    private MissionDao missionDao;
    public static Logger logger = Logger.getLogger(dbIniter.class.getName());
    public void init(ServletConfig config) throws ServletException {
        missionDao = (MissionDao) config.getServletContext().getAttribute("MissionDao");
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user= (User) request.getSession().getAttribute("user");
        String sportsman=request.getParameter("sportsman");
        Integer id=Integer.valueOf(sportsman);
        User id_to=userDao.get(id).get();
        String text=request.getParameter("message");
        LocalDate today = LocalDate.now();
        Mission mission=new Mission(1,user,id_to,text,false,today);
        missionDao.newMission(mission);
        logger.log(Level.INFO,String.format("created new mission"));
        List<Mission> missionsForMySportsmans=missionDao.getTasksForSportsmans(user);
        request.getSession().setAttribute("missionsForMySportsmans", missionsForMySportsmans);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/newTask.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
