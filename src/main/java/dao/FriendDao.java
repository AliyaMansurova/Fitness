package dao;

import java.util.List;

public interface FriendDao {
    List<Integer> getFriendsId(int id_friend1);
    void deleteFriend(int id_friend1,int id_friend2);
    void addFriend(int id_friend1,int id_friend2);
}
