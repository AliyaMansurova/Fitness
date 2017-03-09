package dao;

import model.Message;

public interface MessageDAO {
    void newMessage(Message message);
    void deleteMessage(Message message);
    boolean isRead();
    void messageIsRead(Message message);
}
