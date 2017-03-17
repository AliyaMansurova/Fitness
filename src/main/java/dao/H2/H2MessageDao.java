package dao.H2;

import dao.MessageDao;
import lombok.SneakyThrows;
import model.Message;
import model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class H2MessageDao implements MessageDao {
    private DataSource dataSource;
    public H2MessageDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    @SneakyThrows
    public void newMessage(Message message) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Message(id_from,id_to,message,date)" +
                     "VALUES (?,?,?,?)")) {
            preparedStatement.setObject(1, message.getId_from());
            preparedStatement.setObject(2, message.getId_to());
            preparedStatement.setObject(3, message.getMessage());
            preparedStatement.setObject(4, message.getDate());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    @SneakyThrows
    public void deleteMessage(Message message) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Message WHERE id=?")) {
            preparedStatement.setObject(1, message.getId_from());
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
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Message SET state = 'true' WHERE id=?")) {
            preparedStatement.setObject(1, message.getId());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    @SneakyThrows
    public List<Message> getAll() {
        List<Message> messages = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT id,id_from,id_to,message,date FROM Message")) {
            while (resultSet.next())
                messages.add(new Message(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_from"),
                        resultSet.getInt("id_to"),
                        resultSet.getString("message"),
                        resultSet.getDate("date").toLocalDate()                        //resultSet.getDate("date").toLocalDate()))
                ));
            return messages;
        }
    }

    @Override
    @SneakyThrows
    public List<Message> inMessagesOfUser(User user) {
        List<Message> messages = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,id_from,id_to,message,date FROM Message WHERE id_to=? ")) {
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                messages.add(new Message(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_from"),
                        resultSet.getInt("id_to"),
                        resultSet.getString("message"),
                        resultSet.getDate("date").toLocalDate()
                ));
            }
            return messages;
        }
    }

    @Override
    @SneakyThrows
    public List<Message> outMessagesOfUser(User user) {
        List<Message> messages = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,id_from,id_to,message,date FROM Message WHERE id_from=? ")) {
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                messages.add(new Message(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_from"),
                        resultSet.getInt("id_to"),
                        resultSet.getString("message"),
                        resultSet.getDate("date").toLocalDate()
                ));
            }
            return messages;
        }
    }
}
