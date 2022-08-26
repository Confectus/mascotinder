package model.jpa;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.dao.PetImageDAO;
import model.entities.PetImage;

public class JPAPetImageDAO extends JPAGenericDAO<PetImage, Integer> implements PetImageDAO {

	EntityManager e = Persistence.createEntityManagerFactory("mascotinder").createEntityManager();
	
	public JPAPetImageDAO() {
		super(PetImage.class);
	}

	@Override
	public PetImage getFirstPetImage(Integer petId) {
		PetImage image;
		String sentenceJPQL = "SELECT i FROM PetImage i WHERE i.pet.id= :p1 AND i.pet.petImage.id= :p2";
		Query query = e.createQuery(sentenceJPQL);
		query.setParameter("p1", petId);
		query.setParameter("p2", 1);
		image = (PetImage) query.getSingleResult();
		return image;
	}

}
