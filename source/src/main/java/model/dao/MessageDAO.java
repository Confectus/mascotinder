package model.dao;

import java.util.List;

import model.entities.Message;

public interface MessageDAO extends GenericDAO<Message, Integer>{
	public List<Message> getMessagesByOwnersId(String ownerEmailA ,String ownerEmailB );
}
