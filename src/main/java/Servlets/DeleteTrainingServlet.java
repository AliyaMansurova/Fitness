package Servlets;

import dao.FriendDao;
import dao.TrainingDao;
import dao.UserDao;
import listeners.dbIniter;
import model.Training;
import model.User;
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

@WebServlet(name = "DeleteTrainingServlet")
public class DeleteTrainingServlet extends HttpServlet {
        private TrainingDao trainingDao;
        private UserDao userDao;
    public static Logger logger = Logger.getLogger(dbIniter.class.getName());
        public void init(ServletConfig config) throws ServletException {
            trainingDao = (TrainingDao) config.getServletContext().getAttribute("TrainingDao");
            userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Integer idSportsman = Integer.valueOf(request.getParameter("deleteSportsman"));
            User user = (User) request.getSession().getAttribute("user");
            RequestDispatcher requestDispatcher;
            trainingDao.deleteTraining(user.getId(),idSportsman);
            List<Integer> mySportsmansId = trainingDao.getSportsmansId(user.getId());
            List<User> mySportsmans = new ArrayList<>();
            mySportsmansId.stream().forEach(id -> mySportsmans.add(userDao.get(id).get()));
            request.getSession().setAttribute("mySportsmans", mySportsmans);
            requestDispatcher = request.getRequestDispatcher("/mySportsmans.jsp");
            requestDispatcher.forward(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Integer idTrainer = Integer.valueOf(request.getParameter("deleteTrainer"));
            User user = (User) request.getSession().getAttribute("user");
            RequestDispatcher requestDispatcher;
            trainingDao.deleteTraining(idTrainer, user.getId());
            List<Integer> myTrainersId = trainingDao.getTrainersId(user.getId());
            List<User> myTrainers = new ArrayList<>();
            myTrainersId.stream().forEach(id -> myTrainers.add(userDao.get(id).get()));
            request.getSession().setAttribute("myTrainers", myTrainers);
            requestDispatcher = request.getRequestDispatcher("/myTrainers.jsp");
            requestDispatcher.forward(request, response);
        }
    }

