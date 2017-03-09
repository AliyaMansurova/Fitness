package dao.H2;

import dao.UserDao;
import lombok.SneakyThrows;
import model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class H2UserDao implements UserDao {
    private static final String SQL_SELECT_ALL="SELECT first_name,last_name,patronymic,nickname,dob,telephone,email,password,status_code FROM User";
    private DataSource dataSource;
    @Override
    @SneakyThrows
    public int create(User user) {
        try (Connection connection=dataSource.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT into Users(first_name,last_name,patronymic,nickname,dob," +
                "telephone,email,password,status_code) VALUES (?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setObject(1,"first_name");
            preparedStatement.setObject(2,"last_name");
            preparedStatement.setObject(3,"patronymic");
            preparedStatement.setObject(4,"nickname");
            preparedStatement.setObject(5,"bob");
            preparedStatement.setObject(6,"telephone");
            preparedStatement.setObject(7,"email");
            preparedStatement.setObject(8,"password");
            preparedStatement.setObject(9,"status_code");
            preparedStatement.executeUpdate();


        }
        return 0;
    }

    @Override
    @SneakyThrows
    public void remove(User user) {
        try (Connection connection=dataSource.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM Users WHERE id=?")) {
            preparedStatement.setObject(1,user.getId());
            preparedStatement.executeUpdate();
        }
        }

    @Override
    @SneakyThrows
    public List<User> getAll() {
        List<User> users=new ArrayList<>();
        try(Connection connection=dataSource.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(SQL_SELECT_ALL)){
            while (resultSet.next())
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("nickname"),
                        resultSet.getDate("bob").toLocalDate(),
                        resultSet.getString("telephone"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("status_code")
                ));
            return users;
        }
        }


    @Override
    @SneakyThrows
    public boolean LoginFree(String nickname) {
        try (Connection connection=dataSource.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("SELECT FROM User WHERE nickname=?")) {
            preparedStatement.setObject(1,nickname);
            ResultSet resultSet=preparedStatement.getResultSet();
            if(resultSet.next())
                return false;
            else return true;

        }
    }

    @Override
    public boolean isPasswordCorrect() {
        return false;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User searchUser(String name) {
        return null;
    }
}
