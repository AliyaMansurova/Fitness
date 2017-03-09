package dao.H2;

import dao.MessageDao;
import lombok.SneakyThrows;
import model.Message;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class H2MessageDao implements MessageDao {
    DataSource dataSource;
    @Override
    @SneakyThrows
    public void newMessage(Message message) {
        try (Connection connection=dataSource.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO Message(id_from,id_to,message)" +
                     "VALUES (?,?,?)")){
            preparedStatement.setObject(1,message.getId_from());
            preparedStatement.setObject(2,message.getId_to());
            preparedStatement.setObject(3,message.getMessage());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    @SneakyThrows
    public void deleteMessage(Message message) {
        try (Connection connection=dataSource.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM Message WHERE id=?")){
            preparedStatement.setObject(1,message.getId_from());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    @SneakyThrows
    public boolean isRead(Message message) {
                return false;
    }

    @Override
    @SneakyThrows
    public void messageIsRead(Message message) {
        try (Connection connection=dataSource.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("UPDATE Message SET state = 'true' WHERE id=?")){
            preparedStatement.setObject(1,message.getId());
            preparedStatement.executeUpdate();
        }

    }
}
