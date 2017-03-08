package cp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConnectionPoolTest {
    private String RESOURCES_FILE_PATH="src/test/resources/";
    private ConnectionPool connectionPool = new ConnectionPool(RESOURCES_FILE_PATH  + "sql");
    @Test
    void takeConnection() throws Exception {
        assertNotNull(connectionPool.get());
    }

}
