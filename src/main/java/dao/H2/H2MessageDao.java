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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Message(id_from,id_to,message,date_m)"+
                     "VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, message.getId_from().getId());
            preparedStatement.setObject(2, message.getId_to().getId());
            preparedStatement.setObject(3, message.getMessage());
            preparedStatement.setObject(4, message.getDate());
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next())
                    message.setId(generatedKeys.getInt(1));
            }
        }

    }

    @Override
    @SneakyThrows
    public void deleteMessage(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Message WHERE id=?")) {
            preparedStatement.setObject(1, id);
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
        /*try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Message SET state = 'true' WHERE id=?")) {
            preparedStatement.setObject(1, message.getId());
            preparedStatement.executeUpdate();
        }
*/
    }

    @Override
    @SneakyThrows
    public List<Message> getAll() {
        /*List<Message> messages = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT u.id,u.first_name,u.last_name,u.patronymic," +
                     "u.gender_code,u.dob,u.telephone,u.email,u.password,u.height,u.weight,u.country,u.city,u.status_code,u.rating," +
                     "m.id,m.id_from,m.id_to,m.message,m.date FROM User u,Message m WHERE ")) {
            while (resultSet.next())
                messages.add(new Message(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_from"),
                        resultSet.getInt("id_to"),
                        resultSet.getString("message"),
                        resultSet.getDate("date").toLocalDate()                        //resultSet.getDate("date").toLocalDate()))
                ));
            return messages;*/
        return null;
    }

    @Override
    @SneakyThrows
    public List<Message> inMessagesOfUser(User user) {
        List<Message> messages = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT u.first_name,u.last_name,u.patronymic," +
                             "u.gender_code,u.dob,u.telephone,u.email,u.password,u.height,u.weight,u.country,u.city," +
                             "u.status_code,u.rating,m.id,m.id_from,m.message,m.date_m FROM User u,Message m" +
                             " WHERE m.id_from=u.id AND m.id_to=? ORDER BY m.date_m DESC")) {
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                messages.add(new Message(resultSet.getInt("id"),
                        new User(resultSet.getInt("id_from"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("patronymic"),
                                resultSet.getString("gender_code"),
                                resultSet.getDate("dob").toLocalDate(),
                                resultSet.getString("telephone"),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getDouble("height"),
                                resultSet.getDouble("weight"),
                                resultSet.getString("country"),
                                resultSet.getString("city"),
                                resultSet.getString("status_code"),
                                resultSet.getInt("rating")),
                        user,
                        resultSet.getString("message"),
                        resultSet.getDate("date_m").toLocalDate())
                        );
            }
            return messages;
        }
    }

    @Override
    @SneakyThrows
    public List<Message> outMessagesOfUser(User user) {
        List<Message> messages = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT u.first_name,u.last_name,u.patronymic," +
                     "u.gender_code,u.dob,u.telephone,u.email,u.password,u.height,u.weight,u.country,u.city," +
                     "u.status_code,u.rating,m.id,m.id_to,m.message,m.date_m FROM User u,Message m" +
                     " WHERE m.id_to=u.id AND m.id_from=? ORDER BY m.date_m DESC")) {
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                messages.add(new Message(resultSet.getInt("id"),
                        user,
                        new User(resultSet.getInt("id_to"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("patronymic"),
                                resultSet.getString("gender_code"),
                                resultSet.getDate("dob").toLocalDate(),
                                resultSet.getString("telephone"),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getDouble("height"),
                                resultSet.getDouble("weight"),
                                resultSet.getString("country"),
                                resultSet.getString("city"),
                                resultSet.getString("status_code"),
                                resultSet.getInt("rating")),
                        resultSet.getString("message"),
                        resultSet.getDate("date_m").toLocalDate())
                );
            }
            return messages;
        }
    }
}
