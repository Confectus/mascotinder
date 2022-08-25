package test;

import model.dao.DAOFactory;
import model.entities.Pet;

public class TestJPA {
	
	public static void main(String[] args) {
		Pet pt = new Pet();
		pt.setName("Alta");
		pt.setAge(12);
		pt.setSpecie("x");
		pt.setType("y");
		
		Pet pt2 = new Pet();
		pt.setName("Mope");
		pt.setAge(2);
		pt.setSpecie("x");
		pt.setType("y1");
		
		DAOFactory.getFactory().getPetDAO().create(pt);
		DAOFactory.getFactory().getPetDAO().create(pt2);
		System.out.println("Pets creation");
	}
	
}
