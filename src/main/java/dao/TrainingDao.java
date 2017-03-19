package dao;

import java.util.List;

public interface TrainingDao {
    List<Integer> getTrainersId(int id_sportsman);
    List<Integer> getSportsmansId(int id_friend1);
    void deleteTraining(int id_trainer,int id_sportsman);
    void addTraining(int id_trainer,int id_sportsman);
}
