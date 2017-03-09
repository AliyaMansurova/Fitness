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

    DataSource dataSource;
    @Override
    @SneakyThrows
    public void newMission(Mission mission) {
        try (Connection connection=dataSource.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO Mission(id_traner,id_sportsman,mission,state,date)" +
                     "VALUES (?,?,?,?,?)")){
            preparedStatement.setObject(1,mission.getId_trainer());
            preparedStatement.setObject(2,mission.getId_sportsman());
            preparedStatement.setObject(3,mission.getMission());
            preparedStatement.setObject(4,mission.getState());
            preparedStatement.setObject(5,mission.getData());
            preparedStatement.executeUpdate();

        }

    }

    @Override
    @SneakyThrows
    public void missionIsDone(Mission mission) {

    }

    @Override
    public void deleteMission(Mission mission) {

    }

    @Override
    @SneakyThrows
    public List<Mission> getAllMissions(User user) {
        List<Mission> missions=new ArrayList<>();
        try (Connection connection=dataSource.getConnection();
             Statement statement=connection.createStatement()){
            ResultSet resultSet=statement.executeQuery("SELECT id,id_trainer,id_sportsman,mission,state,date FROM Mission");
            while (resultSet.next())
                missions.add(new Mission(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_trainer"),
                        resultSet.getInt("id_sportsman"),
                        resultSet.getString("mission"),
                        resultSet.getString("state"),
                        resultSet.getDate("date").toLocalDate();}
                       /*  );*/
               // );
            return missions;
    }
}
