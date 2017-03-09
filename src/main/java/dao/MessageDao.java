package dao;

import model.Message;

public interface MessageDao {
    void newMessage(Message message);
    void deleteMessage(Message message);
    boolean isRead(Message message);
    void messageIsRead(Message message);
}
