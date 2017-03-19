package dao.H2;

import dao.TrainingDao;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class H2TrainingDao implements TrainingDao {
    private DataSource dataSource;

    public H2TrainingDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    @SneakyThrows
    public List<Integer> getTrainersId(int id_sportsman) {
        List<Integer> trainers = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_trainer FROM Training " +
                     "WHERE id_sportsman=?")) {
            preparedStatement.setInt(1, id_sportsman);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                trainers.add(resultSet.getInt("id_trainer"));
            }
            return trainers;
        }
    }

    @Override
    @SneakyThrows
    public List<Integer> getSportsmansId(int id_trainer) {
        List<Integer> trainers = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_sportsman FROM Training " +
                     "WHERE id_trainer=?")) {
            preparedStatement.setInt(1, id_trainer);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                trainers.add(resultSet.getInt("id_sportsman"));
            }
            return trainers;
        }
    }

    @Override
    @SneakyThrows
    public void deleteTraining(int id_trainer, int id_sportsman) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Training WHERE id_trainer=? AND id_sportsman=?")) {
            preparedStatement.setInt(1, id_trainer);
            preparedStatement.setInt(2, id_sportsman);
            preparedStatement.executeUpdate();
        }

    }

    @Override
    @SneakyThrows
    public void addTraining(int id_trainer, int id_sportsman) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT into Training(id_trainer,id_sportsman) " +
                     "VALUES (?,?)")) {
            preparedStatement.setInt(1, id_trainer);
            preparedStatement.setInt(2, id_sportsman);
            preparedStatement.executeUpdate();
        }
    }

}

