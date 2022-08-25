package test;

import model.dao.DAOFactory;
import model.entities.Pet;

public class JPAPetTableCreation {
	
	public static void main(String[] args) {
		Pet pt = new Pet();
		pt.setName("Alta");
		pt.setAge(12);
		pt.setSpecie("x");
		pt.setType("y");
		
		Pet pt2 = new Pet();
		pt2.setName("Mope");
		pt2.setAge(2);
		pt2.setSpecie("x");
		pt2.setType("y1");
		
		DAOFactory.getFactory().getPetDAO().create(pt);
		DAOFactory.getFactory().getPetDAO().create(pt2);
		System.out.println("Pets creation");
	}
	
}
