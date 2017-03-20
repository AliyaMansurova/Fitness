package listeners;
import dao.H2.H2FriendDao;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.Level;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
@WebListener
@Log
public class dbIniter implements ServletContextListener {
    public static Logger logger = Logger.getLogger(dbIniter.class.getName());
    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Pattern pattern = Pattern.compile("^\\d+\\.sql$");
        Path sqlDirPath = Paths.get(
                sce.getServletContext().getRealPath("/WEB-INF/classes/sql"));

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             DirectoryStream<Path> paths = Files.newDirectoryStream(sqlDirPath)) {
            for (Path filePath : paths)
                if (pattern.matcher(filePath.toFile().getName()).find()) {
                    statement.addBatch(
                            Files.lines(filePath)
                                    .collect(Collectors.joining())
                    );
                }
            statement.executeBatch();

        } catch (SQLException e) {
            logger.log(org.apache.log4j.Level.ERROR, "Error in dbIniter"+e.getLocalizedMessage());
        } catch (IOException e) {
            logger.log(org.apache.log4j.Level.ERROR, "Error in dbIniter"+e.getLocalizedMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
