package dao;

import model.Mission;
import model.User;

import java.util.List;

public interface MissionDao {
    void newMission(Mission mission);
    void missionIsDone(int id);
    void deleteMission(int id);
    List<Mission>getAchievements(User user);
    List<Mission>getTasks(User user);
    List<Mission>getTasksForSportsmans(User user);
}
