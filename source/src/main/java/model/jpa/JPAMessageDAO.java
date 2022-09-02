package model.jpa;

import java.util.List;
import model.dao.MessageDAO;
import model.entities.Message;

public class JPAMessageDAO extends JPAGenericDAO<Message, Integer> implements MessageDAO{

	public JPAMessageDAO() {
		super(Message.class);
	}

	@Override
	public List<Message> getMessagesByOwnersId(String ownerEmailA, String ownerEmailB) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
