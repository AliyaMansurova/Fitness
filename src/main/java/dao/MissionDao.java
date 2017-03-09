package dao;

import model.Mission;
import model.User;

import java.util.List;

public interface MissionDao {
    void newMission(Mission mission);
    void missionIsDone(Mission mission);
    void deleteMission(Mission mission);
    List<Mission> getAllMissions(User user);
}
