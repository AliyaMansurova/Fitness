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
    private static final String SQL_SELECT_ALL="SELECT id,first_name,last_name,patronymic," +
            "gender_code,nickname,dob,telephone,email,password,height,weight,country,city,status_code,rating FROM User";
    private DataSource dataSource;
    public H2UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    @SneakyThrows
    public int create(User user) {
        try (Connection connection=dataSource.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT into User(first_name,last_name,patronymic," +
                "gender_code,nickname,dob,telephone,email,password,height,weight,country,city,status_code,rating) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setObject(1,user.getFirstName());
            preparedStatement.setObject(2,user.getLastName());
            preparedStatement.setObject(3,user.getPatronymic());
            preparedStatement.setObject(4,user.getGender_code());
            preparedStatement.setObject(5,user.getNickname());
            preparedStatement.setObject(6,user.getDob());
            preparedStatement.setObject(7,user.getTelephone());
            preparedStatement.setObject(8,user.getEmail());
            preparedStatement.setObject(9,user.getPassword());
            preparedStatement.setObject(10,user.getHeight());
            preparedStatement.setObject(11,user.getWeight());
            preparedStatement.setObject(12,user.getCountry());
            preparedStatement.setObject(13,user.getCity());
            preparedStatement.setObject(14,user.getStatus_code());
            preparedStatement.setObject(15,user.getRating());
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
                        resultSet.getString("gender_code"),
                        resultSet.getString("nickname"),
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
        try (Connection connection=dataSource.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("SELECT FROM User WHERE email=?")) {
            preparedStatement.setObject(1,email);
            ResultSet resultSet=preparedStatement.getResultSet();
            if(resultSet.next())
                return false;
            else return true;
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User searchUser(String name) {
        return null;
    }
}
