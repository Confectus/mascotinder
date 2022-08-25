package test;

import java.util.List;

import model.dao.DAOFactory;
import model.entities.Pet;

public class JPATest {

	public static void main(String[] args) {
		buildPet();
		listarMascotas("daniel.garrido@epn.edu.ec");

	}

	
	public static void buildPet() {
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
		
	}
	
	public static void listarMascotas(String correo) {
		List<Pet> lista = DAOFactory.getFactory().getPetDAO().getPetsByOwnerEmail(correo);
		for (Pet pet : lista) {
			System.out.println(pet.toString());
		}
	}
	
}
