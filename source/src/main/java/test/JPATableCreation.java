package test;

import model.dao.DAOFactory;
import model.entities.Owner;
import model.entities.Pet;

public class JPATableCreation {
	
	public static void main(String[] args) {
		
		Owner owner1 = new Owner("francisco.encalada01@epn.edu.ec", "Francisco", "rafa123123", null);		
		DAOFactory.getFactory().getOwnerDAO().create(owner1);
		
		Pet pt = new Pet();
		pt.setName("Alta");
		pt.setAge(12);
		pt.setSpecie("x");
		pt.setType("y");
		pt.setOwner(owner1);
		
		Pet pt2 = new Pet();
		pt2.setName("Mope");
		pt2.setAge(2);
		pt2.setSpecie("x");
		pt2.setType("y1");
		pt2.setOwner(owner1);
		
		DAOFactory.getFactory().getPetDAO().create(pt);
		DAOFactory.getFactory().getPetDAO().create(pt2);		
	}
	
}
