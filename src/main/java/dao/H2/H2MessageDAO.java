package dao.H2;

import dao.MessageDAO;
import model.Message;

public class H2MessageDAO implements MessageDAO {
    @Override
    public void newMessage(Message message) {

    }

    @Override
    public void deleteMessage(Message message) {

    }

    @Override
    public boolean isRead() {
        return false;
    }

    @Override
    public void messageIsRead(Message message) {

    }
}
