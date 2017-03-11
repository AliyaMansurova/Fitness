package listeners;


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
        sce.getServletContext().setAttribute("UserDao", h2UserDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
