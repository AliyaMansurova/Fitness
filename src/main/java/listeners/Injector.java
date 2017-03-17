package listeners;


import dao.H2.H2FriendDao;
import dao.H2.H2UserDao;

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
        sce.getServletContext().setAttribute("UserDao", h2UserDao);
        sce.getServletContext().setAttribute("FriendDao", h2FriendDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
