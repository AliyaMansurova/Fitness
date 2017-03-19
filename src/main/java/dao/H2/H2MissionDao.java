package dao.H2;

import dao.MissionDao;
import lombok.SneakyThrows;
import model.Mission;
import model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class H2MissionDao implements MissionDao {

    private DataSource dataSource;

    public H2MissionDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    @SneakyThrows
    public void newMission(Mission mission) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Mission" +
                     "(id_trainer,id_sportsman,mission,state,date_m)"+
                     "VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, mission.getId_trainer().getId());
            preparedStatement.setObject(2, mission.getId_sportsman().getId());
            preparedStatement.setObject(3, mission.getMission());
            preparedStatement.setObject(4, mission.isState());
            preparedStatement.setObject(5, mission.getDate());
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next())
                    mission.setId(generatedKeys.getInt(1));
            }
        }
    }

    @Override
    @SneakyThrows
    public void missionIsDone(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Mission SET state=TRUE WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }

    }

    @Override
    @SneakyThrows
    public void deleteMission(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Mission WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }


    @Override
    @SneakyThrows
    public List<Mission> getAchievements(User user) {
        List<Mission> achievments = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT u.first_name,u.last_name,u.patronymic," +
                     "u.gender_code,u.dob,u.telephone,u.email,u.password,u.height,u.weight,u.country,u.city," +
                     "u.status_code,u.rating,m.id,m.id_trainer,m.id_sportsman,m.mission,m.state,m.date_m FROM User u,Mission m " +
                     "WHERE m.id_trainer=u.id AND m.id_sportsman=? AND m.state=TRUE")) {
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                achievments.add(new Mission(resultSet.getInt("id"),
                        new User(resultSet.getInt("id_trainer"),
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
                                resultSet.getString(("status_code")),
                                resultSet.getInt("rating")),
                        user,
                        resultSet.getString("mission"),
                        resultSet.getBoolean("state"),
                        resultSet.getDate("date_m").toLocalDate()));
            }
        }
        return achievments;
    }


    @Override
    @SneakyThrows
    public List<Mission> getTasks(User user) {
        List<Mission> tasks = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT u.first_name,u.last_name,u.patronymic," +
                     "u.gender_code,u.dob,u.telephone,u.email,u.password,u.height,u.weight,u.country,u.city," +
                     "u.status_code,u.rating,m.id,m.id_trainer,m.id_sportsman,m.mission,m.state,m.date_m FROM User u,Mission m " +
                     "WHERE m.id_trainer=u.id AND m.id_sportsman=? AND m.state=FALSE")) {
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tasks.add(new Mission(resultSet.getInt("id"),
                        new User(resultSet.getInt("id_trainer"),
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
                                resultSet.getString(("status_code")),
                                resultSet.getInt("rating")),
                        user,
                        resultSet.getString("mission"),
                        resultSet.getBoolean("state"),
                        resultSet.getDate("date_m").toLocalDate()));
            }
        }
        return tasks;
    }

    @Override
    @SneakyThrows
    public List<Mission> getTasksForSportsmans(User user) {
        List<Mission> tasks = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT u.first_name,u.last_name,u.patronymic," +
                     "u.gender_code,u.dob,u.telephone,u.email,u.password,u.height,u.weight,u.country,u.city," +
                     "u.status_code,u.rating,m.id,m.id_trainer,m.id_sportsman,m.mission,m.state,m.date_m FROM User u,Mission m " +
                     "WHERE m.id_sportsman=u.id AND m.id_trainer=? AND m.state=FALSE")) {
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tasks.add(new Mission(resultSet.getInt("id"),
                        user,
                        new User(resultSet.getInt("id_sportsman"),
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
                                resultSet.getString(("status_code")),
                                resultSet.getInt("rating")),
                        resultSet.getString("mission"),
                        resultSet.getBoolean("state"),
                        resultSet.getDate("date_m").toLocalDate()));
            }
        }
        return tasks;

    }
}
