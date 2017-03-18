package dao.H2;

import dao.UserDao;
import lombok.SneakyThrows;
import model.User;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class H2UserDao implements UserDao {
    private static final String SQL_SELECT_ALL = "SELECT id,first_name,last_name,patronymic," +
            "gender_code,dob,telephone,email,password,height,weight,country,city,status_code,rating FROM User";
    private DataSource dataSource;

    public H2UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    @SneakyThrows
    public int create(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT into User(first_name,last_name,patronymic," +
                     "gender_code,dob,telephone,email,password,height,weight,country,city,status_code,rating) " +
                     "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, user.getFirstName());
            preparedStatement.setObject(2, user.getLastName());
            preparedStatement.setObject(3, user.getPatronymic());
            preparedStatement.setObject(4, user.getGender_code());
            preparedStatement.setObject(5, user.getDob());
            preparedStatement.setObject(6, user.getTelephone());
            preparedStatement.setObject(7, user.getEmail());
            preparedStatement.setObject(8, user.getPassword());
            preparedStatement.setObject(9, user.getHeight());
            preparedStatement.setObject(10, user.getWeight());
            preparedStatement.setObject(11, user.getCountry());
            preparedStatement.setObject(12, user.getCity());
            preparedStatement.setObject(13, user.getStatus_code());
            preparedStatement.setObject(14, user.getRating());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next())
                    user.setId(generatedKeys.getInt(1));
            }
        }
        return user.getId();
    }

    @Override
    @SneakyThrows
    public void remove(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Users WHERE id=?")) {
            preparedStatement.setObject(1, user.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    @SneakyThrows
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL)) {
            while (resultSet.next())
                users.add(new User(
                        resultSet.getInt("id"),
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
                        resultSet.getInt("rating")
                ));
            return users;
        }
    }


    @Override
    @SneakyThrows
    public boolean LoginFree(String email) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT email FROM User WHERE email=?")) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return false;
            else return true;
        }
    }

    @Override
    @SneakyThrows
    public void update(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE User SET first_name=?,last_name=?,patronymic=?," +
                     "gender_code=?,dob=?,telephone=?,email=?,password=?,height=?,weight=?,country=?,city=?,status_code=?,rating=? WHERE id=?")) {
            preparedStatement.setObject(1, user.getFirstName());
            preparedStatement.setObject(2, user.getLastName());
            preparedStatement.setObject(3, user.getPatronymic());
            preparedStatement.setObject(4, user.getGender_code());
            preparedStatement.setObject(5, user.getDob());
            preparedStatement.setObject(6, user.getTelephone());
            preparedStatement.setObject(7, user.getEmail());
            preparedStatement.setObject(8, user.getPassword());
            preparedStatement.setObject(9, user.getHeight());
            preparedStatement.setObject(10, user.getWeight());
            preparedStatement.setObject(11, user.getCountry());
            preparedStatement.setObject(12, user.getCity());
            preparedStatement.setObject(13, user.getStatus_code());
            preparedStatement.setObject(14, user.getRating());
            preparedStatement.setObject(15, user.getId());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    @SneakyThrows
    public List<User> searchUsers(User user) {
        List<User> foundUsers = new ArrayList<>();
        ResultSet resultSet;
        String query = "SELECT * FROM User WHERE TRUE ";
        if (!user.getFirstName().equals("") && user.getFirstName() != null) {
            query = query + "AND first_name LIKE '" + user.getFirstName() + "%' ";
        }
        if (!user.getLastName().equals("") && user.getLastName() != null) {
            query = query + "AND last_name LIKE '" + user.getLastName() + "%' ";
        }
        if (user.getGender_code().equals("Female") || user.getGender_code().equals("Male")) {
            query = query + "AND gender_code LIKE '" + user.getGender_code() + "%'";
        }
        query += " ORDER BY last_name ASC, first_name ASC;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                foundUsers.add(new User(
                                resultSet.getInt("id"),
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
                                resultSet.getInt("rating")
                        )
                );
            }
        return foundUsers;
    }
}
}
