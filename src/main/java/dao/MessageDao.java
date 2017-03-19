package dao;

import model.Message;
import model.User;

import java.util.List;
import java.util.Optional;

public interface MessageDao {
    void newMessage(Message message);
    void deleteMessage(int id);
    boolean isRead(Message message);
    void messageIsRead(Message message);
    List <Message> getAll();
    List <Message> inMessagesOfUser(User user);
    List <Message> outMessagesOfUser(User user);

}
