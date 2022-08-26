package test;

import model.dao.DAOFactory;
import model.entities.Owner;
import model.entities.Pet;

public class JPATableCreation {
	
	public static void main(String[] args) {
		
		// owners creations
		Owner owner1 = new Owner("francisco.encalada01@epn.edu.ec", "Francisco", "rafa123123");		
		DAOFactory.getFactory().getOwnerDAO().create(owner1);
		System.out.println("Owners creation was done!");
		
		// pets creations
		Pet pt = new Pet();
		pt.setName("Alta");
		pt.setAge(12);
		pt.setSex("male");
		pt.setType("y");
		pt.setOwner(owner1);
		
		Pet pt2 = new Pet();
		pt2.setName("Mope");
		pt2.setAge(2);
		pt2.setSex("female");
		pt2.setType("y1");
		pt2.setOwner(owner1);
		
		DAOFactory.getFactory().getPetDAO().create(pt);
		DAOFactory.getFactory().getPetDAO().create(pt2);
		System.out.println("Pets creation was done!");
	}
	
}
