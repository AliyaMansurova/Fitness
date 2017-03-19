package listeners;


import dao.H2.*;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
@WebListener
public class Injector implements ServletContextListener{
    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        H2UserDao h2UserDao = new H2UserDao(dataSource);
        H2FriendDao h2FriendDao=new H2FriendDao(dataSource);
        H2MessageDao h2MessageDao=new H2MessageDao(dataSource);
        H2MissionDao h2MissionDao=new H2MissionDao(dataSource);
        H2TrainingDao h2TrainingDao=new H2TrainingDao(dataSource);
        sce.getServletContext().setAttribute("UserDao", h2UserDao);
        sce.getServletContext().setAttribute("FriendDao", h2FriendDao);
        sce.getServletContext().setAttribute("MessageDao",h2MessageDao);
        sce.getServletContext().setAttribute("MissionDao",h2MissionDao);
        sce.getServletContext().setAttribute("TrainingDao",h2TrainingDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
